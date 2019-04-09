package com.mtm.examples.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mtm.examples.domain.Customer;
import com.mtm.examples.domain.CustomerType;
import com.mtm.examples.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(
				Customer.builder().id(1).pesel("12345").name("Adam Kowalski").type(CustomerType.INDIVIDUAL).build());
		customers.add(
				Customer.builder().id(2).pesel("12346").name("Anna Malinowska").type(CustomerType.INDIVIDUAL).build());
		customers.add(
				Customer.builder().id(3).pesel("12347").name("Paweł Michalski").type(CustomerType.INDIVIDUAL).build());
		customers.add(Customer.builder().id(4).pesel("12348").name("Karolina Lewandowska").type(CustomerType.INDIVIDUAL)
				.build());
		return customers;
	}

	@Override
	public Customer findByPesel(String pesel) {
		return getCustomers().parallelStream().filter(account -> account.getPesel().equals(pesel)).findFirst().get();
	}

	@Override
	public Customer findById(Integer id) {
		return getCustomers().stream().filter(account -> account.getId().intValue() == id.intValue()).findFirst().get();
	}

	@Override
	public List<Customer> findAll() {
		return getCustomers();
	}

}