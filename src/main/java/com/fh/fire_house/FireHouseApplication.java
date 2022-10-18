package com.fh.fire_house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class FireHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FireHouseApplication.class, args);
    }

}
