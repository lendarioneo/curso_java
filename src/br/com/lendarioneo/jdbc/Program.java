package br.com.lendarioneo.jdbc;

import br.com.lendarioneo.jdbc.model.dao.DaoFactory;
import br.com.lendarioneo.jdbc.model.dao.SellerDao;
import br.com.lendarioneo.jdbc.model.entities.Department;
import br.com.lendarioneo.jdbc.model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        //Department department = new Department(1, "Books");
        //Seller seller = new Seller(1, "Bob", "bob@gmail.com", new Date(), 3000.0, department);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        // Seller seller = sellerDao.findById(3);
//        for (Seller seller1 : sellerDao.findByDepartment(2)) {
//            System.out.println(seller1);
//        }

        for (Seller seller : sellerDao.findAll()) {
            System.out.println(seller);
        }
    }
}
