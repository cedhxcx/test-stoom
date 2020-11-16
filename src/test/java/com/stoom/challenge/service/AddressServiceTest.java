package com.stoom.challenge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.stoom.challenge.dto.AddressDTO;
import com.stoom.challenge.entities.Address;
import com.stoom.challenge.repositories.AddressRepository;
import com.stoom.challenge.services.AddressService;
import com.stoom.challenge.services.exception.ResourceNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

	@Mock
	private AddressRepository repository;

	@InjectMocks
	private AddressService service;

	@Test
	public void shouldFindAllAddress() {
		Address address = AddressFixture.getInstance();
		Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(address));
		List<AddressDTO> listDto = service.findAll();
		listDto.forEach(a -> {
			assertEquals(address.getId(), a.getId());
			assertEquals(address.getStreetName(), a.getStreetName());
			assertEquals(address.getNumber(), a.getNumber());
			assertEquals(address.getComplement(), a.getComplement());
			assertEquals(address.getNeighbourhood(), a.getNeighbourhood());
			assertEquals(address.getCity(), a.getCity());
		});

	}
	
	@Test
	public void shouldDeleteByIdSuccessfully() {
		Long id = 1L;
		service.delete(id);
		assertThat(repository.findById(id)).isNotPresent();		
	}
	


	@Test(expected = ResourceNotFoundException.class)
	public void shouldReceiveExcepetionWhenDeleteIdNotFound() {
		when(repository.getOne(anyLong())).thenThrow(EntityNotFoundException.class);
		service.update(AddressFixture.getInstance());
	}

}
