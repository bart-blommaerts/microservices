package be.daggie.microservices.sync;

public class Person {

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