package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Annotation: SpringBootApplication, spring boot will auto configuration when start this project

@SpringBootApplication
public class HelloWorldDemoApplication {
    public static void main(String[] args) {
       SpringApplication.run(HelloWorldDemoApplication.class);
    }
}
