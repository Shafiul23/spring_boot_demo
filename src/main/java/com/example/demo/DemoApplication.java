package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class  DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(
			StudentRepository repository, MongoTemplate mongoTemplate) {
//			StudentRepository repository) {
		return args -> {
			Address address = new Address(
					"England",
					"London",
					"NW9"
			);

			String email = "jahmed@email.com";
			Student student = new Student(
					"Jamila",
					"Ahmed",
					email,
					Gender.FEMALE,
					address,
					BigDecimal.TEN,
					LocalDateTime.now()
			);
//			usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
//		repository.findStudentByEmail(email)
//				.ifPresent( s -> { // ifPresentOrElse would be better here but this was introduced in a later version of java (13)
//					System.out.println("Inserting student " + student);
//					repository.insert(student);
//				});
//			System.out.println("Inserting student... " + student);
//			repository.insert(student);
//		};
//	}

//	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email));

			List<Student> students = mongoTemplate.find(query, Student.class);

			if (students.size() > 1) {
				throw new IllegalStateException("found many students with email " + email);
			}

			if (students.isEmpty()) {
				System.out.println("Inserting student " + student);
				repository.insert(student);
			} else {
				System.out.println(student + " already exists");
			}
		};
	}
}
