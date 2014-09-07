package be.daggie.microservices.sync;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	private Long id;
	private String street;
	private Integer houseNumber;
	private String zipCode;
	private String city;
	private String country;

	public Address() {
	}
	
	public Address(Long id, String street, Integer houseNumber, String zipCode, String city, String country) {
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public String getStreet() {
		return street;
	}

	@JsonProperty
	public Integer getHouseNumber() {
		return houseNumber;
	}

	@JsonProperty
	public String getZipCode() {
		return zipCode;
	}

	@JsonProperty
	public String getCity() {
		return city;
	}

	@JsonProperty
	public String getCountry() {
		return country;
	}
}
