package be.daggie.microservices.sync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	private PersonProvider provider;
	public PersonController() {
		provider = new PersonProvider();
	}

	@RequestMapping("/person")
	public Person getPerson(
			@RequestParam(value = "id", required = true) Long id) {
		return provider.getPerson(id);
	}
}
