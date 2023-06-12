package ru.otus.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.model.Question;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/spring-context.xml"})
class QuestionServiceTest {

    private QuestionService questionService;

    @BeforeEach
    public void setUp() {
        questionService = new QuestionService("questionsAndAnswers.csv");
    }

    @Test
    void getDataFromResourceFile() {
        InputStream inputStream = questionService.getDataFromResourceFile();
        assertNotNull(inputStream);
    }

    @Test
    void getQuestionsFromCSVFile() {
        List<Question> questionsList = questionService.getQuestionsFromCSVFile();
        assertEquals(5, questionsList.size());
    }
}