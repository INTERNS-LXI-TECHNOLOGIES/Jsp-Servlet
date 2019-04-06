package com.lxisoft.contactapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.contactapp.model.Address;
import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	public Address createAddress(Address address) {
		return addressRepository.save(address);
	}
	
	@Override
	public Optional<Address> getAddress(Long id) {
		return addressRepository.findById(id);
	}
	
}
