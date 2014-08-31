package be.daggie.microservices.async;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -6091995317790396337L;
	private final Long id;
	private final String firstName;
	private final String lastName;
	private final Long adresId;

	public Person(Long id, String firstName, String lastName, Long adresId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adresId = adresId;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getAdresId() {
		return adresId;
	}
}