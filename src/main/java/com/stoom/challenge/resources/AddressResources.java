package com.stoom.challenge.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoom.challenge.entities.Address;

@RestController
@RequestMapping(value ="/addresses")
public class AddressResources {
	
	@GetMapping
	public ResponseEntity<Address> findAll(){
		Address a = new Address(1L, "Leonor de Castro", "64", "casa 4", "curuça", "Sao Paulo", "Sao Paulo", "Brasil", "08031510", "5551566", "151515");
		return ResponseEntity.ok().body(a);
		
	}

}


