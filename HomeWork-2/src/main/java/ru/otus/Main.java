package ru.otus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.config.AppConfig;
import ru.otus.service.RunTestService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        RunTestService runTestService = context.getBean(RunTestService.class);
        runTestService.runTest();
    }
}

