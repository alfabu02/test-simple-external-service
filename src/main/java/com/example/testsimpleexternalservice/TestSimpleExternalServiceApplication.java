package com.example.testsimpleexternalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoAuditing
@EnableMongoRepositories
@SpringBootApplication
public class TestSimpleExternalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSimpleExternalServiceApplication.class, args);
    }

}
