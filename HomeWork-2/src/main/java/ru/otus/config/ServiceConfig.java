package ru.otus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.service.StudentService;
import ru.otus.service.StudentServiceImpl;

import java.util.Scanner;

@Configuration
public class ServiceConfig {

    @Bean
    StudentService studentService() {
        return new StudentServiceImpl(new Scanner(System.in));
    }
}
