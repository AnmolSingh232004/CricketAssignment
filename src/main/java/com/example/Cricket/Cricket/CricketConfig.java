package com.example.Cricket.Cricket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CricketConfig {
    @Bean
    CommandLineRunner commandLineRunner(CricketRepository cricketRepository) {
        return args -> {
            Player player1 = new Player("Dhoni", "India", 60L, 560L, "Delhi", 10L);
            cricketRepository.saveAll(List.of(player1));
        };
    }
}
