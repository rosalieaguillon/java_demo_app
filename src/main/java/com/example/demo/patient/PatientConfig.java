package com.example.demo.patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PatientConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            PatientRepository repository) {
        return args -> {
            Patient tata = new Patient(
                    "tata",
                    "tata@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            Patient toto = new Patient(
                    "Toto",
                    "toto@gmail.com",
                    LocalDate.of(2001, Month.FEBRUARY, 6)
            );
            repository.saveAll(
                    List.of(tata, toto)
            );
        };
    }
}
