package br.com.lendarioneo.jdbc;

import br.com.lendarioneo.jdbc.model.dao.DaoFactory;
import br.com.lendarioneo.jdbc.model.dao.SellerDao;
import br.com.lendarioneo.jdbc.model.entities.Department;
import br.com.lendarioneo.jdbc.model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Department department = new Department(1, "Books");

        /*Teste do Get por Id*/
        //Seller seller = new Seller(1, "Bob", "bob@gmail.com", new Date(), 3000.0, department);
        //System.out.println(seller);

        /*Teste do get por Id de Departamento*/
        // Seller seller = sellerDao.findById(3);
        //for (Seller seller1 : sellerDao.findByDepartment(2)) {
        //System.out.println(seller1);

        /*Teste do listar todos*/
        //for (Seller seller : sellerDao.findAll()) {
        //    System.out.println(seller);
        //}

        /*Teste do Insert*/
        Seller seller = new Seller(null, "Greg","greg@gmail.com", new Date(), 4.000, department);
        sellerDao.insert(seller);
        System.out.println("Inserido! Novo Id é : " + seller.getId());
    }
}
