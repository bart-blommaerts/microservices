package be.daggie.microservices.async;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository {
	private Map<Long, Person> personMap;
	
	public PersonRepository() {
		personMap = new HashMap<Long, Person>();
		
		Person p = new Person(1L, "Bart", "Blommaerts", 1L);
		addPerson(p);
		
		p = new Person(2L, "Iris", "Geeraerts", 1L);
		addPerson(p);
		
		p = new Person(3L, "Mathis", "Blommaerts", 1L);
		addPerson(p);
	}
	
	public Map<Long, Person> getAllPersons() {
		return personMap;
	}
	
	public void addPerson(Person p) {
		personMap.put(p.getId(), p);
	}
}
