package com.partho.springboot.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.partho.springboot.bo.Product;

@Repository
public class ProductRepository implements IProductRepository {

	private static List<Product> products = new ArrayList<>();
	private static AtomicInteger counter = new AtomicInteger(0);
	static {
		products.add(new Product(counter.incrementAndGet(), "First"));
		products.add(new Product(counter.incrementAndGet(), "Second"));
		products.add(new Product(counter.incrementAndGet(), "Third"));
		products.add(new Product(counter.incrementAndGet(), "Fourth"));
	}

	@Override
	public List<Product> findAll() {
		return products;
	}

	@Override
	public List<Product> findByName(String name) {
		return products.stream().filter(p -> p.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	@Override
	public boolean addProduct(Product product) {
		product.setId(counter.incrementAndGet());
		return products.add(product);
	}

	@Override
	public void removeProduct(long id) {
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if (product.getId() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public Product findById(long id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

}
