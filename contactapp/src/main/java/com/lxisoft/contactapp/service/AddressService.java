package com.lxisoft.contactapp.service;

import java.util.List;
import java.util.Optional;

import com.lxisoft.contactapp.model.Address;

public interface AddressService {

	Address createAddress(Address address);

	Optional<Address> getAddress(Integer id);

	List<Address> getAllAddreses();

	Address updateAddress(Address address);

	void deleteAddress(Integer id);

}
