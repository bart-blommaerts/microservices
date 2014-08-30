package be.daggie.microservices.sync;

import java.util.HashMap;
import java.util.Map;

public class AddressRepository {
private Map<Long, Address> addressMap;
	
	public AddressRepository() {
		addressMap = new HashMap<Long, Address>();

		Address a = new Address(1L, "Brederodestraat", 16, "1000", "Brussels", "Belgium");  
		putAddress(a);
		
		a = new Address(2L, "Koninklijk Parklaan", 100, "1020", "Brussels", "Belgium");  
		putAddress(a);
		
		a = new Address(3L, "Burgemeester Vandenbogaerdelaan ", 16, "8870", "Izegem", "Belgium");
		putAddress(a);
	}
	
	public Address getAddress(Long id) {
		return addressMap.get(id);
	}
	
	private void putAddress(Address p) {
		addressMap.put(p.getId(), p);
	}
}
