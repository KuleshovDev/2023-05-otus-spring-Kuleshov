package ru.otus.service;

import ru.otus.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {

    private final String file;


    public QuestionService(String file) {
        this.file = file;
    }

    public InputStream getDataFromResourceFile() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResourceAsStream(file);
    }

    public List<Question> getQuestionsFromCSVFile() {
        List<Question> questionsList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getDataFromResourceFile()));
            String line;
            int questionNumber = 1; // переменная для отслеживания номера строки
            while ((line = reader.readLine()) != null) {
                if (line.contains("?")) {
                    String questionText = line.trim();
                    Question question = new Question(questionNumber, questionText);
                    questionsList.add(question);
                    questionNumber++; // увеличиваем номер строки после каждого чтения
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return questionsList;
    }
}
