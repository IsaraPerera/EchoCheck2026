package com.example.ecocheck2026;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcoCheck2026Application {
    static void main(String[] args) {
        SpringApplication.run(EcoCheck2026Application.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){
         return new ModelMapper();
    }

}

