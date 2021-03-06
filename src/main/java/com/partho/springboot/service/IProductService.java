package com.partho.springboot.service;

import java.util.List;

import com.partho.springboot.bo.Product;

public interface IProductService {

	List<Product> findAll();
    List<Product> findByName(String name);
    boolean addProduct(Product product);
	void removeProduct(long id);
	Product findById(long id);
}
