package com.partho.springboot.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.partho.springboot.bo.Product;

@Repository
public class ProductRepository implements IProductRepository{

	private List<Product> products = Arrays.asList(new Product(1, "First"), new Product(2, "Second"));
	@Override
	public List<Product> findAll() {
		return products;
	}

}
