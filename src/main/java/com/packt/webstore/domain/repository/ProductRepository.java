package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts(); 
	List<Product> getProductByCategory(String category);
	List<Product> filterProducts(Map<String, List<String>> filterParams);
	Product getById(String id);
	void updateStock(String productId, long units);
	void addProduct(Product product);
}
