package com.projectincremental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.projectincremental.entities"})
public class ProjectIncrementalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectIncrementalApplication.class, args);
	}

}
