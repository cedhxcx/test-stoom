package com.stoom.challenge.mapper;

import com.stoom.challenge.dto.AddressDTO;
import com.stoom.challenge.entities.Address;

public class AddressMapper {
	
	public static AddressDTO map(Address address) {
		AddressDTO addresDto = new  AddressDTO();
		addresDto.setId(address.getId());
		addresDto.setStreetName(address.getStreetName());
		addresDto.setNumber(address.getNumber());
		addresDto.setComplement(address.getComplement());
		addresDto.setNeighbourhood(address.getNeighbourhood());
		addresDto.setCity(address.getCity());
		addresDto.setState(address.getState());
		addresDto.setCountry(address.getCountry());
		addresDto.setZipcode(address.getZipCode());
		addresDto.setLatitude(address.getLatitude());
		addresDto.setLongitude(address.getLongitude());
		
		return addresDto;
		
	}

}
