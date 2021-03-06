package com.mtm.examples.service;

import java.util.List;

import com.mtm.examples.domain.Customer;

public interface CustomerService {

	public Customer findByPesel(String pesel);

	public Customer findByCustomerId(Integer customerId);

	public List<Customer> findAll();

}