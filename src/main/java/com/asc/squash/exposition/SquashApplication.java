package com.asc.squash.exposition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.asc.squash"})
@EnableJpaRepositories(basePackages = {"com.asc.squash"})
@EntityScan("com.asc.squash")
//@EnableSwagger2
public class SquashApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquashApplication.class, args);
	}

}
