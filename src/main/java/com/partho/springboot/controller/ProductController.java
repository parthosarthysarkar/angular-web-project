package com.partho.springboot.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/product/{search-term}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProducts(@PathVariable("search-term") String searchTerm) {
		List<Product> products = productService.findByName(searchTerm);
		if (Objects.isNull(products))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		boolean result = productService.addProduct(product);
		if (result)
			return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> removeProduct(@PathVariable("id") long id) {
		Product product = productService.findById(id);
		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		productService.removeProduct(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}
}
