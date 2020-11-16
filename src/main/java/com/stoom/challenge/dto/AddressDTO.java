package com.stoom.challenge.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.stoom.challenge.entities.Address;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;

	@NotNull(message = "street name cannot be empty")
	private String streetName;

	@NotNull(message = "number cannot be empty")
	private String number;
	private String complement;

	@NotNull(message = "neighbourhood cannot be empty")
	private String neighbourhood;

	@NotNull(message = "city  cannot be empty")
	private String city;

	@NotNull(message = "state  cannot be empty")
	private String state;

	@NotNull(message = "country  cannot be empty")
	private String country;

	@NotNull(message = "zipcode cannot be empty")
	private String zipcode;

	private String latitude;
	private String longitude;

	public AddressDTO() {
	}

	public AddressDTO(Address obj) {
		id = obj.getId();
		streetName = obj.getStreetName();
		number = obj.getNumber();
		complement = obj.getComplement();
		neighbourhood = obj.getNeighbourhood();
		city = obj.getCity();
		state = obj.getState();
		country = obj.getCountry();
		zipcode = obj.getZipcode();
		latitude = obj.getLatitude();
		longitude = obj.getLongitude();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
