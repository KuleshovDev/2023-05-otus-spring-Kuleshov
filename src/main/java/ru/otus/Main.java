package ru.otus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.RunTestService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        RunTestService runTestService = context.getBean(RunTestService.class);
        runTestService.runTest();
    }
}

