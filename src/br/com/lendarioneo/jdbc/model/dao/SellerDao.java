package br.com.lendarioneo.jdbc.model.dao;

import br.com.lendarioneo.jdbc.model.entities.Seller;

import java.util.List;

public interface SellerDao {

    Seller insert(Seller seller);

    Seller update(Seller seller);

    Seller findById(int id);

    List<Seller> findByDepartment(int id);

    List<Seller> findAll();

    Seller deleteById(int id);
}
