package com.lxisoft.contactapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.contactapp.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

	
}
