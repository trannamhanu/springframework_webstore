package com.trann.webstore.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trann.webstore.domain.Product;
import com.trann.webstore.domain.repository.ProductRepository;
import com.trann.webstore.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
	
	public void updateAllStocks() {
		List<Product> allProducts = productRepository.getAllProducts();
		for (Product p : allProducts) {
			if (p.getUnitsInStock() < 500) {
				productRepository.updateStock(p.getProductId(), p.getUnitsInStock() + 1000);
			} 
		}
	}

	public List<Product> getProductByCategory(String category) {
		return productRepository.getProductByCategory(category);
	}

	public List<Product> filterProducts(Map<String, List<String>> filterParams) {
		return productRepository.filterProducts(filterParams);
	}

	public Product getById(String id) {
		return productRepository.getById(id);
	}

	public void addProduct(Product product) {
		productRepository.addProduct(product);
		
	}
	
	public void update(Product product) {
		productRepository.update(product);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}
	
}
