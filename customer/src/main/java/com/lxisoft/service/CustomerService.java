package com.lxisoft.service;

import java.util.List;  

import com.lxisoft.repo.CustomerRepo;
import com.lxisoft.repo.Repo;
import com.lxisoft.sample.Customer;

public class CustomerService implements CustomerService1 {

	CustomerRepo cr= new Repo();
	
	public List<Customer> findAll(){
		return cr.findAll();
	}
}
