package com.lxisoft.contactapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.contactapp.model.Address;
import com.lxisoft.contactapp.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	@PostMapping("/api/newad")
	public ResponseEntity<Address> createAddress(@RequestBody Address address) throws URISyntaxException{
		
		Address result=addressService.createAddress(address);
		return ResponseEntity.created(new URI("/api/new/"+result.getId()))
				.header("X-address-created", result.toString())
				.body(result);
		}
	
		@GetMapping("/api/getad/{id}")
		public ResponseEntity<Address> readAddress(@PathVariable Integer id) {
		
			Optional<Address> result = addressService.getAddress(id);
			return ResponseEntity.of(result);
		}
		
		@GetMapping("/api/getad")
		public ResponseEntity<List<Address>> readAllAddreses() {
		
			List<Address> result = addressService.getAllAddreses();
			return ResponseEntity.ok()
					.body(result);
		}
		@PutMapping("/api/updatead")
		public ResponseEntity<Address> updateAddress(@RequestBody Address address) throws URISyntaxException {
			if(address.getId()!=0)
			{
				Address result = addressService.updateAddress(address);
				return ResponseEntity.ok()
			            .header("X-address-updated", result.toString())
			            .body(result);
			}
			return ResponseEntity.badRequest()
					.body(null);
		}
		@DeleteMapping("/api/deletead/{id}")
		public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
			
			addressService.deleteAddress(id);
			return ResponseEntity.ok()
			.header("X-address-deleted", id.toString())
			.build();
		}
		
	
}
