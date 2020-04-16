package br.com.lendarioneo.jdbc.model.dao;

import br.com.lendarioneo.jdbc.model.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller seller);

    void update(Seller seller);

    Seller findById(int index);

    List<Seller> findAll();

    void deleteById(int index);
}
