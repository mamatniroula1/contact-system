package com.restapi.contactsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication

public class ContactSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactSystemApplication.class, args);
    }

}
