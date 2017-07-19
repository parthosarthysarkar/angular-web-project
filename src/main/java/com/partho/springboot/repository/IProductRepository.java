package com.partho.springboot.repository;

import java.util.List;

import com.partho.springboot.bo.Product;

public interface IProductRepository {

	List<Product> findAll();
}
