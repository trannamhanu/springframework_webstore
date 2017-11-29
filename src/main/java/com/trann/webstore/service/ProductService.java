package com.trann.webstore.service;

import java.util.List;
import java.util.Map;

import com.trann.webstore.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	List<Product> getProductByCategory(String category);
	List<Product> filterProducts(Map<String, List<String>> filterParams);
	Product getById(String id);
	void updateAllStocks();
	void addProduct(Product product);
	void update(Product product);
	void delete(Product product);
}
