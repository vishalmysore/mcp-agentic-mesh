package org.example.desert;

import io.github.vishalmysore.tools4ai.EnableAgent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAgent
@PropertySource("classpath:application-dessert.properties")
public class DessertServer {

    public static void main(String[] args) {
        SpringApplication.run(DessertServer.class, args);
    }
}
