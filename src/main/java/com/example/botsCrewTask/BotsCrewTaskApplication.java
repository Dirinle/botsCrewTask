package com.example.botsCrewTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotsCrewTaskApplication implements CommandLineRunner {
    @Autowired
    private ConsoleInterface consoleInterface;

    public static void main(String[] args) {
        SpringApplication.run(BotsCrewTaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        consoleInterface.start();
    }
}
