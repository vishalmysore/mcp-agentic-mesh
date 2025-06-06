package org.example.restaurant;

import io.github.vishalmysore.tools4ai.EnableAgent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAgent
@PropertySource("classpath:application-restaurant.properties")
public class RestaurantServer {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantServer.class, args);
    }
}
