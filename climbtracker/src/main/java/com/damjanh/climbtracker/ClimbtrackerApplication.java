package com.damjanh.climbtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ClimbtrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClimbtrackerApplication.class, args);
    }

}
