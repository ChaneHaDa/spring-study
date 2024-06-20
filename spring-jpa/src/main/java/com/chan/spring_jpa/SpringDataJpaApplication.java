package com.chan.spring_jpa;

import com.chan.spring_jpa.constant.RoleType;
import com.chan.spring_jpa.jpa.entity.Person;
import com.chan.spring_jpa.jpa.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PersonRepository personRepository) {
		return args -> {
			Person person = new Person(null, "Chan", 25, RoleType.ADMIN, "Chan", "Kang");
			personRepository.save(person);
		};
	}

}
