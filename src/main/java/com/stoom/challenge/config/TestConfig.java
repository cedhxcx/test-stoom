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
		Address a1 = new Address(null, "rua blabla", "1321", "casa 3", "curuça", "sao paulo", "sao paulo", "brasil", "080565784", "123456", "-654321");
		Address a2 = new Address(null, "rua tunico", "34242", "casa 1", "brigadeiro", "sao paulo", "sao paulo", "brasil", "080565784", "123456", "-654321");
		Address a3 = new Address(null, "rua pinhanguça", "666", "apto 2", "morrinho alto", "Rio de janeiro", "Rio de Janeiro", "brasil", "080565784", "123456", "-654321");
		
		addressRepository.saveAll(Arrays.asList(a1,a2,a3));
	}
}