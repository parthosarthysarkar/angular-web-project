package com.partho.springboot.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.partho.springboot.bo.Product;
import com.partho.springboot.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/products", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productService.findAll();
		if (Objects.isNull(products))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
