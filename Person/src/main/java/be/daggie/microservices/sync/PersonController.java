package be.daggie.microservices.sync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	private PersonRepository repository;
	public PersonController() {
		repository = new PersonRepository();
	}

	@RequestMapping("/person")
	public Person getPerson(
			@RequestParam(value = "id", required = true) Long id) {
		return repository.getPerson(id);
	}
}
