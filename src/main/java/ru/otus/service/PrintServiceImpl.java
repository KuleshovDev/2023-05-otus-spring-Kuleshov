package ru.otus.service;

import ru.otus.model.Answer;
import ru.otus.model.Question;

import java.util.List;

public class PrintServiceImpl implements PrintService {

    private final QuestionService questionService;

    private final AnswerService answerService;

    public PrintServiceImpl(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @Override
    public void printTest() {
        List<Question> questionList = questionService.getQuestionsFromCSVFile();
        List<Answer> answerList = answerService.getAnswersFromCSVFile();

        for (int i = 0; i < questionList.size(); i++) {
            Question question = questionList.get(i);
            Answer answer = answerList.get(i);

            System.out.println(question.getQuestion());
            System.out.println(answer.getAnswer());
            System.out.println();
        }
    }
}
