package com.stoom.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoom.challenge.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
