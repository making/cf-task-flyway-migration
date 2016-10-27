package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class FlywayMigrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlywayMigrationApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(JdbcTemplate jdbcTemplate) {
		return a -> {
			jdbcTemplate.queryForList("SELECT * FROM demo").forEach(x -> {
				System.out.println(x);
			});
		};
	}
}
