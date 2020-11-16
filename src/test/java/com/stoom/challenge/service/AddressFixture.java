package com.stoom.challenge.service;

import com.stoom.challenge.entities.Address;

public class AddressFixture {

	public static Address getInstance() {
		Address address = new Address();
		address.setId(1L);
		address.setStreetName("rua teste unitario");
		address.setNumber("66");
		address.setComplement("casa 3");
		address.setNeighbourhood("brigadeiro");
		address.setCity("Sao Paulo");
		address.setState("São Paulo");
		address.setCountry("Brasil");
		address.setZipCode("08321548");
		address.setLatitude("123456789");
		address.setLongitude("-987654321");
		return address;

	}
}
