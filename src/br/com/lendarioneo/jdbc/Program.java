package br.com.lendarioneo.jdbc;

import br.com.lendarioneo.jdbc.model.dao.DaoFactory;
import br.com.lendarioneo.jdbc.model.dao.DepartmentDao;
import br.com.lendarioneo.jdbc.model.dao.SellerDao;
import br.com.lendarioneo.jdbc.model.entities.Department;
import br.com.lendarioneo.jdbc.model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        //SellerDao sellerDao = DaoFactory.createSellerDao();
        //Department department = new Department(1, "Books");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

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
        //Seller seller = new Seller(null, "Greg","greg@gmail.com", new Date(), 4.000, department);
        //sellerDao.insert(seller);
        //System.out.println("Inserido! Novo Id é : " + seller.getId());

        /*Teste do update*/
        //Seller seller = sellerDao.findById(1);
        //System.out.println("Funcionario pesquisado: " + seller);
        //seller.setName("Martha Wayne");
        //sellerDao.update(seller);
        //System.out.println("Funcionario atualizado: " + seller);

        /*Teste do Delete*/
        //sellerDao.deleteById(7);
        //System.out.println("Vendedor deletado!");

        /*Teste de GetById Department*/
        //System.out.println(departmentDao.findById(1));

        /*Teste de GetAll Department*/
        //for (Department department: departmentDao.findAll()){
        //    System.out.println(department);
        //}

        /*Teste de Insert Department*/
        //Department department = new Department(null, "Drinks");
        //departmentDao.insert(department);
        //System.out.println("Novo registro criado: " + department);

        /*Teste de update Department*/
        //Department department = departmentDao.findById(2);
        //department.setName("Smartphones");
        //departmentDao.update(department);
        //System.out.println("Departamento atualizado: " + department);

        /*Teste de delete*/
        departmentDao.deleteById(5);
        System.out.println("Delete realizado com sucesso!");
    }
}
