package be.daggie.microservices.async;

import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonListener {
	
	private ObjectMapper mapper;
	
	public PersonListener() {
		mapper = new ObjectMapper();
	}

	public void receiveMessage(Map<Integer, Person> message) throws JsonProcessingException {
	    Iterator<Map.Entry<Integer, Person>> it = message.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Integer, Person> pairs = (Map.Entry<Integer, Person>)it.next();
	        System.out.println(mapper.writeValueAsString(pairs.getValue()));
	        it.remove();
	    }
	}
}