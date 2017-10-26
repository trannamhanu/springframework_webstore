package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Product> getAllProducts() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Product> result = jdbcTemplate.query("SELECT * FROM PRODUCTS", params, new ProductMapper());
		return result;
	}

	private static final class ProductMapper implements RowMapper<Product> {

		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getString("ID"));
			product.setName(rs.getString("NAME"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
			product.setManufacturer(rs.getString("MANUFACTURER"));
			product.setCategory(rs.getString("CATEGORY"));
			product.setCondition(rs.getString("CONDITION"));
			product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
			product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
			product.setDiscounted(rs.getBoolean("DISCOUNTED"));
			return product;
		}

	}

	public void updateStock(String productId, long units) {
		String sql = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :stock WHERE ID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("stock", units);
		params.put("id", productId);
		jdbcTemplate.update(sql, params);
	}

	public List<Product> getProductByCategory(String category) {
		String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY = :category";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category);
		return jdbcTemplate.query(sql, params, new ProductMapper());
	}

	public List<Product> filterProducts(Map<String, List<String>> filterParams) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM PRODUCTS WHERE CATEGORY IN (:categories)");
		sql.append(" AND MANUFACTURER IN (:brands)");
		return jdbcTemplate.query(sql.toString(), filterParams, new ProductMapper());
	}

	public Product getById(String id) {
		String sql = "SELECT * FROM PRODUCTS WHERE ID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		try {
			return jdbcTemplate.queryForObject(sql, params, new ProductMapper());
		} catch (DataAccessException e) {
			throw new ProductNotFoundException(id);
		}
	}

	public void addProduct(Product product) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, UNIT_PRICE,");
		sql.append(" MANUFACTURER, CATEGORY, CONDITION, UNITS_IN_STOCK,");
		sql.append(" UNITS_IN_ORDER, DISCOUNTED) VALUES (:id, :name,");
		sql.append(" :description, :price, :manufacturer, :category,");
		sql.append(" :condition, :inStock, :inOrder, :discount)");

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", product.getProductId());
		params.put("name", product.getName());
		params.put("description", product.getDescription());
		params.put("price", product.getUnitPrice());
		params.put("manufacturer", product.getManufacturer());
		params.put("category", product.getCategory());
		params.put("condition", product.getCondition());
		params.put("inStock", product.getUnitsInStock());
		params.put("inOrder", product.getUnitsInOrder());
		params.put("discount", product.isDiscounted());

		jdbcTemplate.update(sql.toString(), params);

	}

}
