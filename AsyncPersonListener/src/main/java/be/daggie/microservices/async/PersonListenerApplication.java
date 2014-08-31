package be.daggie.microservices.async;

import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class PersonListenerApplication {

	@Bean
	private PersonListener listener() {
		return new PersonListener();
	}

	@Bean
	private MessageListenerAdapter listenerAdapter(PersonListener listener) {
		return new MessageListenerAdapter(listener, "receiveMessage");
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(PersonListenerApplication.class, args);
	}
}
