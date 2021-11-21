package com.asc.squash.exposition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.asc.squash"})
@EnableJpaRepositories(basePackages = {"com.asc.squash"})
@EntityScan("com.asc.squash")
@EnableSwagger2
public class SquashApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SquashApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(SquashApplication.class, args);
		LOG.info("Application is running!\n look at http://localhost:8181/swagger-ui.html");
	}

}
