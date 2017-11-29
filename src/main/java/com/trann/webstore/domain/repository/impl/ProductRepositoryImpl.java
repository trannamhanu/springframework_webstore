package com.trann.webstore.domain.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.trann.webstore.domain.Product;
import com.trann.webstore.domain.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl extends AbstractDao<String, Product> implements ProductRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		Criteria criteria = createEntityCriteria();
		return (List<Product>) criteria.list();
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> filterProducts(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(String id) {
		return getByKey(id);
	}

	@Override
	public void updateStock(String productId, long units) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProduct(Product product) {
		super.persist(product);
	}
	
	@Override
	public void update(Product product) {
		super.update(product);
	}
	
	@Override
	public void delete(Product product) {
		super.delete(product);
	}
	
}
