package be.daggie.microservices.async;

import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class AddressListenerApplication {

	@Bean
	private AddressListener listener() {
		return new AddressListener();
	}

	@Bean
	private MessageListenerAdapter listenerAdapter(AddressListener listener) {
		return new MessageListenerAdapter(listener, "receiveMessage");
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(AddressListenerApplication.class, args);
	}
}
