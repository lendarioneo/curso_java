package br.com.lendarioneo.jdbc.model.dao.impl;

import br.com.lendarioneo.jdbc.db.DB;
import br.com.lendarioneo.jdbc.db.DBException;
import br.com.lendarioneo.jdbc.model.dao.DepartmentDao;
import br.com.lendarioneo.jdbc.model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection connection;

    public DepartmentDaoJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Department department) {
        String sql =
                "INSERT INTO department (Name) VALUES (?);";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, department.getName());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()){
                    int id = resultSet.getInt(1);
                    department.setId(id);
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
    public void update(Department department) {
        String sql = "UPDATE department SET department.Name = ? WHERE department.Id = ?;";

        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getId());
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
    public Department findById(int index) {
        String query = "SELECT * FROM department WHERE department.Id = ?;";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return this.instantiateDepartment(resultSet);
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

    @Override
    public List<Department> findAll() {
        String query = "SELECT * FROM department ORDER BY department.Id;";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = this.connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            List<Department> departments = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (resultSet.next()) {
                Department department = map.get(resultSet.getInt("Id"));
                if (department == null) {
                    department = this.instantiateDepartment(resultSet);
                    map.put(resultSet.getInt("Id"), department);
                }
                departments.add(this.instantiateDepartment(resultSet));
            }
            return departments;
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
        String sql = "DELETE FROM department WHERE department.Id = ?";
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

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
        return new Department(
                resultSet.getInt("Id"),
                resultSet.getString("Name")
        );
    }
}
