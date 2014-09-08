package be.daggie.microservices.async;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 4131061360757150677L;
	
	private Long id;
	private String street;
	private Integer houseNumber;
	private String zipCode;
	private String city;
	private String country;

	public Address(Long id, String street, Integer houseNumber, String zipCode, String city, String country) {
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}
}
