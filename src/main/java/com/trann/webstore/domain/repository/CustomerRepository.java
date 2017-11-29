package com.trann.webstore.domain.repository;

import java.util.List;

import com.trann.webstore.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
