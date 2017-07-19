package com.partho.springboot.service;

import java.util.List;

import com.partho.springboot.bo.Product;

public interface IProductService {

	List<Product> findAll();
}
