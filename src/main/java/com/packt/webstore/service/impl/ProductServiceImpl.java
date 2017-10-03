package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
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
	
}
