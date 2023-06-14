package ru.otus.service;

import org.springframework.stereotype.Component;
import ru.otus.model.Answer;
import ru.otus.model.Question;
import ru.otus.model.Result;
import ru.otus.model.Student;

import java.util.List;
import java.util.Scanner;

@Component
public class PrintServiceImpl implements PrintService {

    private static final int PASSING_SCORE = 3;

    private final QuestionService questionService;

    private final AnswerService answerService;

    private final StudentService studentService;

    public PrintServiceImpl(QuestionService questionService,
                            AnswerService answerService,
                            StudentService studentService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.studentService = studentService;
    }

    @Override
    public void printTest() {
        Student student = studentService.getStudentInfo();
        List<Question> questionList = questionService.getQuestionsFromCSVFile();
        List<Answer> answerList = answerService.getAnswersFromCSVFile();
        int resultInt = 0;
        int answerNumber = 1;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questionList.size(); i++) {
            Question question = questionList.get(i);
            Answer answer = answerList.get(i);
            System.out.println(question.getQuestion());
            System.out.println(answer.getAnswer());
            int userAnswerIndex = getUserAnswerIndex(scanner);
            for (Answer answers : answerList) {
                if (answers.getCorrectNumber().equals(userAnswerIndex)) {
                    resultInt++;
                    break;
                }
            }
            answerNumber++;
        }
        Result result = new Result(resultInt, student);
        System.out.println(result);
        printResult(result, student);
    }

    void printResult(Result result, Student student) {
        if (PASSING_SCORE <= result.getResult()) {
            System.out.println("Congratulations " + student + " ! You passed football test!");
        } else {
            System.out.println(student + " ,You failed football test!");
        }
    }

    private int getUserAnswerIndex(Scanner scanner) {
        while (true) {
            try {
                int userAnswerIndex = Integer.parseInt(scanner.nextLine().trim());
                if (userAnswerIndex >= 1 && userAnswerIndex <= 4) {
                    return userAnswerIndex;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}

