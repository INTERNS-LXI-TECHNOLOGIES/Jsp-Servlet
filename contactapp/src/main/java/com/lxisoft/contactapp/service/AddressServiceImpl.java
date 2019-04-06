package com.lxisoft.contactapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.contactapp.model.Address;
import com.lxisoft.contactapp.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	@Override
	public Address createAddress(Address address) {
		
		return addressRepository.save(address);
	}

	@Override
	public Optional<Address> getAddress(Integer id) {
		
		return addressRepository.findById(id);
	}
	

	@Override
	public List<Address> getAllAddreses() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}

	@Override
	public Address updateAddress(Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}

	@Override
	public void deleteAddress(Integer id) {
		// TODO Auto-generated method stub
		addressRepository.delete(addressRepository.getOne(id));
	}

}
