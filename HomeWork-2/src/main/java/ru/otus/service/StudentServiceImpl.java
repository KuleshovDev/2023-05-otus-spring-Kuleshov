package ru.otus.service;

import ru.otus.model.Student;

import java.util.Scanner;

public class StudentServiceImpl implements StudentService {

    private final Scanner scanner;

    public StudentServiceImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Student getStudentInfo() {
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        return new Student(firstName, lastName);
    }
}
