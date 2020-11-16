package com.stoom.challenge.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stoom.challenge.dto.AddressDTO;
import com.stoom.challenge.entities.Address;
import com.stoom.challenge.services.AddressService;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResources {

	@Autowired
	private AddressService service;

	@GetMapping
	public ResponseEntity<List<AddressDTO>> findAll() {
		List<Address> list = service.findAll();
		List<AddressDTO> listDto = list.stream().map(x -> new AddressDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AddressDTO> findById(@PathVariable Long id){
		Address obj = service.findById(id);
		return ResponseEntity.ok().body(new AddressDTO(obj));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AddressDTO objDto){
		Address obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody AddressDTO objDto, @PathVariable Long id){
		Address obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
