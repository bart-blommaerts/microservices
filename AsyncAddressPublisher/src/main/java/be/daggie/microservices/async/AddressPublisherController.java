package be.daggie.microservices.async;

import java.util.UUID;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressPublisherController {

	@Autowired
	RabbitTemplate rabbitTemplate;

	public AddressPublisherController() {
	}

	@Bean
	Queue queue() {
		return new Queue(Constants.ADDRESS_QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(Constants.ADDRESS_TOPIC_EXCHANGE);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange)
				.with(Constants.ADDRESS_QUEUE_NAME);
	}

	@RequestMapping("/updateAddress")
	public Address updateAddress(
			@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "street", required = true) String street,
			@RequestParam(value = "houseNumber", required = true) Integer houseNumber,
			@RequestParam(value = "zipCode", required = true) String zipCode,
			@RequestParam(value = "city", required = true) String city,
			@RequestParam(value = "country", required = true) String country) {

		Address a = new Address(id, street, houseNumber, zipCode, city, country);

		rabbitTemplate.setMessageConverter(getMessageConverter());
		
		System.out.println("Sending Update of address: " + id);
		rabbitTemplate.convertAndSend(Constants.ADDRESS_QUEUE_NAME, a);

		return a;
	}

	private MessageConverter getMessageConverter() {
		CorrelationIdMessageConverter mc = new CorrelationIdMessageConverter();
		mc.setCorrellationId(UUID.randomUUID().toString());
		
		System.out.println("Sending CorrelationId: " + mc.getCorrelationId());

		return mc;
	}
}
