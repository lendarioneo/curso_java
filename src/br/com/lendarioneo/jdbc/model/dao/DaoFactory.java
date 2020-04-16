package br.com.lendarioneo.jdbc.model.dao;

import br.com.lendarioneo.jdbc.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
