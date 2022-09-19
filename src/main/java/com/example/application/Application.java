package com.example.application;

import com.example.application.service.impl.CommandService;
import com.example.application.service.impl.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private GreetingService greetingService;
    @Autowired
    private CommandService commandService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        greetingService.greet();
        commandService.processCommand();
    }
}
