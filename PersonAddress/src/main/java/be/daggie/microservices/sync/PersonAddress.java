package be.daggie.microservices.sync;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * In an actual application, I would suggest a modular setup, where Person and Address are reused between services. 
 * See the slides on "Efficiently".
 */
public class PersonAddress {
	private final Person person;
	private final Address address;

	public PersonAddress(Person person, Address address) {
		this.person = person;
		this.address = address;
	}
	
	@JsonProperty
	public Person getPerson() {
		return person;
	}

	@JsonProperty
	public Address getAddress() {
		return address;
	}
}
