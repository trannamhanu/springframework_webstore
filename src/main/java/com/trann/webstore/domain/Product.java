package com.trann.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name="products")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 483231337832781795L;
	
	@Id
	@Column(name="ID")
	private String productId;
	@Column(name="P_NAME")
	private String name;
	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="MANUFACTURER")
	private String manufacturer;
	@Column(name="CATEGORY")
	private String category;
	@Column(name="UNITS_IN_STOCK")
	private long unitsInStock;
	@Column(name="UNITS_IN_ORDER")
	private long unitsInOrder;
	@Column(name="DISCOUNTED")
	private boolean isDiscounted;
	@Column(name="P_CONDITION")
	private String condition;
	@Transient
	private MultipartFile productImage;
	@Transient
	private MultipartFile productGuide;
	
	public Product() {
		super();
	}
	
	public Product(String productId, String name, BigDecimal unitPrice) {
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public boolean isDiscounted() {
		return isDiscounted;
	}

	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	@JsonIgnore
	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	@JsonIgnore
	@XmlTransient
	public MultipartFile getProductGuide() {
		return productGuide;
	}

	public void setProductGuide(MultipartFile productGuide) {
		this.productGuide = productGuide;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null) return false;
		
		if (getClass() != object.getClass()) return false;
		
		Product other = (Product) object;
		if (productId == null) {
			if (other.getProductId() != null) return false;
		} else if (!productId.equals(other.productId)) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
	
}
