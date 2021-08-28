package com.example.gsbatchprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GsBatchProcessingApplication {

    public static void main(String[] args) {
        //SpringApplication.run(GsBatchProcessingApplication.class, args);
        System.exit(SpringApplication.exit(SpringApplication.run(GsBatchProcessingApplication.class, args)));
    }

}
