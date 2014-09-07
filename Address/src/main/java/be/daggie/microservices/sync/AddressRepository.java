package be.daggie.microservices.sync;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.daggie.microservices.sync.Address;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AddressRepository {

	private Map<Long, Address> addressMap;

	public AddressRepository() {
		addressMap = new HashMap<Long, Address>();
	}

	public Address getAddress(Long id) {
		convertListToMap(getCurrentAddressesFromFile());
		
		return addressMap.get(id);
	}

	private List<Address> getCurrentAddressesFromFile() {
		ObjectMapper mapper = new ObjectMapper();
		List<Address> addresses = null;
		try {
			addresses = Arrays.asList(mapper.readValue(new File("/home/bart/files/addresses.json"), Address[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return addresses;
	}
	
	private void convertListToMap(List<Address> addresses) {
		for (Address address : addresses) {
			putAddress(address);
		}
	}
	
	private void putAddress(Address p) {
		addressMap.put(p.getId(), p);
	}
}
