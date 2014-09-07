package be.daggie.microservices.sync;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AddressRepository {

	private Map<Long, Address> addressMap;

	public AddressRepository() {
		ObjectMapper mapper = new ObjectMapper();
		addressMap = new HashMap<Long, Address>();

		try {
			List<Address> addresses = Arrays.asList(mapper.readValue(new File("/home/bart/files/addresses.json"), Address[].class));
			for (Address address : addresses) {
				putAddress(address);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Address getAddress(Long id) {
		return addressMap.get(id);
	}

	private void putAddress(Address p) {
		addressMap.put(p.getId(), p);
	}
}
