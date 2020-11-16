package com.stoom.challenge.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stoom.challenge.ChallengeApplication;
import com.stoom.challenge.dto.AddressDTO;
import com.stoom.challenge.entities.Address;
import com.stoom.challenge.mapper.AddressMapper;
import com.stoom.challenge.repositories.AddressRepository;
import com.stoom.challenge.services.exception.ResourceNotFoundException;


@Service
public class AddressService {
	
	private static Logger logger = LoggerFactory.getLogger(ChallengeApplication.class);

	@Autowired
	private AddressRepository repository;

	public List<AddressDTO> findAll() {
		logger.info("Initializing list AddressDTO method");
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
		logger.info("Initializing delete Address method");
		try {
			repository.deleteById(id);
			logger.info("Address id: "+ id +" has been deleted.");
		} catch (EmptyResultDataAccessException e) {
			logger.error("Address id: "+ id +" was not found.");
			throw new ResourceNotFoundException(id);
		}
	}

	public Address update(Address obj) {
		logger.info("Initializing update Address method");
		try {
			Address entity = repository.getOne(obj.getId());
			updateData(entity, obj);
			logger.error("Address id: "+ obj.getId() + "was updated.");
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			logger.error("Address id: "+ obj.getId() +" was not found.");
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
		entity.setZipCode(obj.getZipCode());
		entity.setLatitude(obj.getLatitude());
		entity.setLongitude(obj.getLongitude());

	}

}
