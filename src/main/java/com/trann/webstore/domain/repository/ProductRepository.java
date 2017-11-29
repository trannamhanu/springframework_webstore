package com.trann.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.trann.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts(); 
	List<Product> getProductByCategory(String category);
	List<Product> filterProducts(Map<String, List<String>> filterParams);
	Product getById(String id);
	void updateStock(String productId, long units);
	void addProduct(Product product);
	void update(Product product);
	void delete(Product product);
}
