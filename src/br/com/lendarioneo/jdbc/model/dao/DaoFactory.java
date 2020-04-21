package br.com.lendarioneo.jdbc.model.dao;

import br.com.lendarioneo.jdbc.db.DB;
import br.com.lendarioneo.jdbc.model.dao.impl.DepartmentDaoJDBC;
import br.com.lendarioneo.jdbc.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
