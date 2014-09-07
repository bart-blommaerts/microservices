package be.daggie.microservices.sync;

import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/personaddress")
@Produces(MediaType.APPLICATION_JSON)
public class PersonAddressResource {

	private final Client client;

	public PersonAddressResource(Client client) {
		this.client = client;
	}

	@GET
	public PersonAddress getPersonAddress(@QueryParam("id") Long id)
			throws URISyntaxException {
		Person p = getPerson(id);
		
		Address a = getAddress(p.getAdresId());

		return new PersonAddress(p, a);
	}
	
	private Person getPerson(Long id) {
		WebResource webResource = client.resource("http://localhost:7890/person?id=" + id);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		return response.getEntity(Person.class);
	}
	
	private Address getAddress(Long id) {
		WebResource webResource = client.resource("http://localhost:7891/address/" + id);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		return response.getEntity(Address.class);
	}
}
