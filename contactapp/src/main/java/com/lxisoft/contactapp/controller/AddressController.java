package com.lxisoft.contactapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.contactapp.model.Address;
import com.lxisoft.contactapp.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/api/create")
	public ResponseEntity<Address> createAddress(@RequestBody Address address) throws URISyntaxException {
		Address result = addressService.createAddress(address);
		return ResponseEntity.created(new URI("/api/create/createAd/"+result.getId()))
				.header("X-address-created", result.toString())
				.body(result);
	}
	
	@GetMapping("/api/get/{id}/")
	public ResponseEntity<Address> readAddress(@PathVariable Long id) {
		Optional<Address> result = addressService.getAddress(id);
		return ResponseEntity.of(result);
	}
}
