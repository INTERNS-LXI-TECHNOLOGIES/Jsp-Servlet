package com.lxisoft.contactapp.service;


import java.util.Optional;

import com.lxisoft.contactapp.model.Address;
import com.lxisoft.contactapp.model.Contact;

public interface AddressService {

	Address createAddress(Address address);

	Optional<Address> getAddress(Long id);
}
