package org.example.gym;


import io.github.vishalmysore.tools4ai.EnableAgent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
// run this pgm with -Dtools4ai.properties.path=tools4ai_library.properties
// or put the properties tools4ai.properties.path in the  application-library.properties file
@SpringBootApplication
@EnableAgent
@PropertySource("classpath:application-gym.properties")
public class GymServer {

    public static void main(String[] args) {
        SpringApplication.run(GymServer.class, args);
    }

}
