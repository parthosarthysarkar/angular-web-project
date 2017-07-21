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
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public boolean addProduct(Product product) {
		return productRepository.addProduct(product);
	}

	@Override
	public void removeProduct(long id) {
		productRepository.removeProduct(id);
	}

	@Override
	public Product findById(long id) {
		return productRepository.findById(id);
	}

}
