package com.partho.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partho.springboot.bo.Product;
import com.partho.springboot.repository.IProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
