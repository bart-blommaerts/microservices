package be.daggie.microservices.sync;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.sun.jersey.api.client.Client;

public class PersonAddressApplication extends
		Application<PersonAddressConfiguration> {
	public static void main(String[] args) throws Exception {
		new PersonAddressApplication().run(args);
	}

	@Override
	public String getName() {
		return "personaddress";
	}

	@Override
	public void initialize(Bootstrap<PersonAddressConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(PersonAddressConfiguration configuration,
			Environment environment) {
		final Client client = new JerseyClientBuilder(environment).using(
				configuration.getJerseyClientConfiguration()).build(getName());
		
		final PersonAddressResource resource = new PersonAddressResource(client);
		final PersonAddressHealthCheck personAddressHealthCheck = new PersonAddressHealthCheck();

		
		environment.healthChecks().register("personaddress", personAddressHealthCheck);
		environment.jersey().register(resource);
	}
}