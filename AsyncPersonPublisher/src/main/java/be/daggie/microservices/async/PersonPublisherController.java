package be.daggie.microservices.async;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonPublisherController {
	
	private static final String QUEUE_NAME = "person-queue";
	private static final String TOPIC_EXCHANGE = "person-exchange";
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	private PersonRepository repository;
	
	public PersonPublisherController() {
		repository = new PersonRepository();
	}
	
	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(TOPIC_EXCHANGE);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_NAME);
	}

	@RequestMapping("/send")
	public void sendAllPersons() throws InterruptedException {
        System.out.println("Waiting five seconds...");
        Thread.sleep(5000);
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(QUEUE_NAME, repository.getAllPersons());
	}
	
	@RequestMapping("/addperson")
	public Person addPerson(
			@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "adresId", required = true) Long adresId) {
		
		Person person = new Person(id, firstName, lastName, adresId);
		repository.addPerson(person);
		
		return person;
	}
}
