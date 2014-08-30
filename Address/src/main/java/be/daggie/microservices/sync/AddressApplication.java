package be.daggie.microservices.sync;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AddressApplication extends Application<AddressConfiguration> {
	public static void main(String[] args) throws Exception {
		new AddressApplication().run(args);
	}

	@Override
	public String getName() {
		return "address";
	}

	@Override
	public void initialize(Bootstrap<AddressConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(AddressConfiguration configuration, Environment environment) {
		final AddressResource resource = new AddressResource();
		final AddressHealthCheck addressHealthCheck = new AddressHealthCheck();

		environment.healthChecks().register("address", addressHealthCheck);
		environment.jersey().register(resource);
	}
}