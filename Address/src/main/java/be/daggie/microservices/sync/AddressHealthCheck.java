package be.daggie.microservices.sync;

import com.codahale.metrics.health.HealthCheck;

public class AddressHealthCheck extends HealthCheck {

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}

}
