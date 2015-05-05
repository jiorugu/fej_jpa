package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import demo.model.Filiale;
import demo.service.FilialeService;

@Import(Config.class)
public class FejJpaApplication implements CommandLineRunner {

	@Autowired
	private FilialeService filiale;

	public static void main(String[] args) {
		SpringApplication.run(FejJpaApplication.class, args);

	}

	@Override
	@Transactional
	public void run(String... arg0) throws Exception {

		test();
	}

	public void test() {
		List<Filiale> list = filiale.findByNameLike("Schanzstrasse");
		System.out.println("List: " + list + " (" + list.size() + " entries)");
		for (Filiale a : list)
			System.out.println(a);
	}
}
