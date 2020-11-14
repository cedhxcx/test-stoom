package com.stoom.challenge.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.stoom.challenge.entities.Address;
import com.stoom.challenge.repositories.AddressRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Address a1 = new Address(null, "Leonor de Castro", "64", "casa 4", "curuça", "Sao Paulo", "Sao Paulo", "Brasil", "08031510", "5551566", "151515");
		Address a2 = new Address(null, "Leonor de Castro", "64", "casa 4", "curuça", "Sao Paulo", "Sao Paulo", "Brasil", "08031510", "5551566", "151515");
		
		addressRepository.saveAll(Arrays.asList(a1,a2));
	}
}