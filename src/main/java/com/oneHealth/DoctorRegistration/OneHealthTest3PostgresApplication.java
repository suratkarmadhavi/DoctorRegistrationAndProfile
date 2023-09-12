package com.oneHealth.DoctorRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the main class for the OneHealthTest3PostgresApplication.
 * It is annotated with @SpringBootApplication, indicating that it's a Spring Boot application.
 * It's also annotated with @RestController, indicating that it's a RESTful controller.
 * 
 * This class is responsible for starting the Spring Boot application.
 * 
 * @author Anup
 * @version 1.0
 */
@SpringBootApplication
@RestController
public class OneHealthTest3PostgresApplication {

    public static void main(String[] args) {
        // This method starts the Spring Boot application.
        SpringApplication.run(OneHealthTest3PostgresApplication.class, args);
    }

    @GetMapping
    public String Welcome() {
        // This method handles GET requests to the root URL and returns a welcome message.
        return "Welcome From OneHealth Team (OneHealth-DoctorRegistrationProfileService)!!!";
    }

}
