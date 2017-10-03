package com.packt.webstore.domain;

import java.io.Serializable;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3396286792319663971L;
	
	private String customerId;
	private String name;
	private String address;
	private Integer noOfOrdersMade;
	
	public Customer() {
		
	}
	
	public Customer(String customerId, String name, String address, Integer noOfOrdersMade) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.noOfOrdersMade = noOfOrdersMade;
	}
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	public void setNoOfOrdersMade(Integer noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
	
	

}
