package com.example.demo.doctor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DoctorConfig {
    @Bean
    CommandLineRunner commandLineRunner_Doctor(
            DoctorRepository repository) {
        return args -> {
            Doctor lala = new Doctor(
                    "Lala",
                    "lala@gmail.com",
                    "generalist"
            );
            Doctor lolo = new Doctor(
                    "Lolo",
                    "lolo@gmail.com",
                    "osteopath"
            );
            repository.saveAll(
                    List.of(lala, lolo)
            );
        };
    }
}
