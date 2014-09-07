package be.daggie.microservices.sync;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private Long id;
	private String firstName;
	private String lastName;
	private Long adresId;

	public Person() {
	}
	
	public Person(Long id, String firstName, String lastName, Long adresId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adresId = adresId;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}
	
	@JsonProperty
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty
	public String getLastName() {
		return lastName;
	}

	@JsonProperty
	public Long getAdresId() {
		return adresId;
	}
}