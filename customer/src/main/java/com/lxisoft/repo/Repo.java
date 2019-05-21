package com.lxisoft.repo;

import java.util.*;

import com.lxisoft.sample.Customer;

public class Repo implements CustomerRepo {

	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setfName("Rahul");
		customer.setlName("P R");
		customers.add(customer);
		return customers;
	}
}
