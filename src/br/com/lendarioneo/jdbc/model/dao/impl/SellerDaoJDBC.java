package br.com.lendarioneo.jdbc.model.dao.impl;

import br.com.lendarioneo.jdbc.db.DB;
import br.com.lendarioneo.jdbc.db.DBException;
import br.com.lendarioneo.jdbc.model.dao.SellerDao;
import br.com.lendarioneo.jdbc.model.entities.Department;
import br.com.lendarioneo.jdbc.model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {

    private Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller seller) {
        String sql =
                "INSERT INTO seller " +
                "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                "VALUES (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, seller.getName());
            preparedStatement.setString(2, seller.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
            preparedStatement.setDouble(4, seller.getBaseSalary());
            preparedStatement.setInt(5, seller.getDepartment().getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()){
                    int id = resultSet.getInt(1);
                    seller.setId(id);
                }
                DB.closeResultSet(resultSet);
            }
            else {
                throw new DBException("Error inesperado! Nenhuma linha foi afetada!");
            }
        }

        catch (SQLException e) {
            throw new DBException(e.getMessage());
        }

        finally {
            DB.closeStatement(preparedStatement);
        }
    }

    @Override
    public void update(Seller seller) {
        String sql =
                "UPDATE seller " +
                "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " +
                "WHERE Id = ?;";

        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, seller.getName());
            preparedStatement.setString(2, seller.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
            preparedStatement.setDouble(4, seller.getBaseSalary());
            preparedStatement.setInt(5, seller.getDepartment().getId());
            preparedStatement.setInt(6, seller.getId());
            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            throw new DBException(e.getMessage());
        }

        finally {
            DB.closeStatement(preparedStatement);
        }
    }

    @Override
    public Seller findById(int id) {
        String query =
                "SELECT seller.*, department.Name as DepName " +
                "FROM seller " +
                "INNER JOIN department " +
                "ON seller.DepartmentId = department.Id " +
                "WHERE seller.Id = ?;";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return this.instantiateSeller(resultSet, this.instantiateDepartment(resultSet));
            }
            return null;
        }

        catch (SQLException e) {
            throw new DBException(e.getMessage());
        }

        finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    public List<Seller> findByDepartment(int id){
        String query =
                "SELECT seller.*, department.Name as DepName " +
                "FROM seller " +
                "INNER JOIN department " +
                "ON DepartmentId = department.Id " +
                "WHERE DepartmentId = ?;";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            List<Seller> sellers = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (resultSet.next()) {
                Department department = map.get(resultSet.getInt("DepartmentId"));
                if (department == null){
                    department = this.instantiateDepartment(resultSet);
                    map.put(resultSet.getInt("DepartmentId"), department);
                }
                sellers.add(this.instantiateSeller(resultSet, department));
            }
            return sellers;
        }

        catch (SQLException e) {
            throw new DBException(e.getMessage());
        }

        finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Seller> findAll() {
        String query =
                "SELECT seller.*, department.Name as DepName " +
                "FROM seller " +
                "INNER JOIN department " +
                "ON DepartmentId = department.Id " +
                "ORDER BY seller.Id;";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = this.connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            List<Seller> sellers = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (resultSet.next()) {
                Department department = map.get(resultSet.getInt("DepartmentId"));
                if (department == null) {
                    department = this.instantiateDepartment(resultSet);
                    map.put(resultSet.getInt("DepartmentId"), department);
                }
                sellers.add(this.instantiateSeller(resultSet, department));
            }
            return sellers;
        }

        catch (SQLException e) {
                throw new DBException(e.getMessage());
        }

        finally {
                DB.closeStatement(preparedStatement);
                DB.closeResultSet(resultSet);
        }
    }

    @Override
    public void deleteById(int index) {
        String sql = "DELETE FROM seller WHERE id = ?";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, index);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }

        finally {
            DB.closeStatement(preparedStatement);
        }
    }

    private Seller instantiateSeller(ResultSet resultSet, Department department) throws SQLException {
        return new Seller(
                    resultSet.getInt("Id"),
                    resultSet.getString("Name"),
                    resultSet.getString("Email"),
                    resultSet.getDate("BirthDate"),
                    resultSet.getDouble("BaseSalary"),
                    department
        );
    }

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
        return new Department(
                resultSet.getInt("DepartmentId"),
                resultSet.getString("DepName")
        );
    }
}
