package be.daggie.microservices.sync;

import java.util.HashMap;
import java.util.Map;

public class PersonProvider {
	private Map<Long, Person> personMap;
	
	public PersonProvider() {
		personMap = new HashMap<Long, Person>();
		
		Person p = new Person(1L, "Bart", "Blommaerts", 1L);
		putPerson(p);
		
		p = new Person(2L, "Iris", "Geeraerts", 1L);
		putPerson(p);
		
		p = new Person(3L, "Mathis", "Blommaerts", 1L);
		putPerson(p);
	}
	
	public Person getPerson(Long id) {
		return personMap.get(id);
	}
	
	private void putPerson(Person p) {
		personMap.put(p.getId(), p);
	}
}
