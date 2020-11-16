package com.stoom.challenge.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stoom.challenge.dto.AddressDTO;
import com.stoom.challenge.entities.Address;
import com.stoom.challenge.mapper.AddressMapper;
import com.stoom.challenge.repositories.AddressRepository;
import com.stoom.challenge.services.exception.ResourceNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	public List<AddressDTO> findAll() {		
		List<Address> addresses = repository.findAll();
		if(!addresses.isEmpty()) {
			return addresses.stream().map(address -> AddressMapper.map(address)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Address insert(Address obj) {
		return repository.save(obj);

	}

	public Address fromDTO(AddressDTO objDto) {
		return new Address(objDto.getId(), objDto.getStreetName(), objDto.getNumber(), objDto.getComplement(),
				objDto.getNeighbourhood(), objDto.getCity(), objDto.getState(), objDto.getCountry(),
				objDto.getZipcode(), objDto.getLatitude(), objDto.getLongitude());
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Address update(Address obj) {
		try {
			Address entity = repository.getOne(obj.getId());
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(obj.getId());
		}
	}

	private void updateData(Address entity, Address obj) {
		entity.setStreetName(obj.getStreetName());
		entity.setNumber(obj.getNumber());
		entity.setComplement(obj.getComplement());
		entity.setNeighbourhood(obj.getNeighbourhood());
		entity.setCity(obj.getCity());
		entity.setState(obj.getState());
		entity.setCountry(obj.getCountry());
		entity.setZipcode(obj.getZipcode());
		entity.setLatitude(obj.getLatitude());
		entity.setLongitude(obj.getLongitude());

	}

}
