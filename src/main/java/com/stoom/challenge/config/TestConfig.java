package com.stoom.challenge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.stoom.challenge.repositories.AddressRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void run(String... args) throws Exception {

	}

}