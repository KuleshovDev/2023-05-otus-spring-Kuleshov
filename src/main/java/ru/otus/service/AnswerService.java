package ru.otus.service;

import ru.otus.model.Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AnswerService {

    private final String file;

    public AnswerService(String file) {
        this.file = file;
    }

    public InputStream getDataFromResourceFile() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResourceAsStream(file);
    }

    public List<Answer> getAnswersFromCSVFile() {
        List<Answer> answersList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getDataFromResourceFile()));

            String line;
            int answerNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (line.contains(";")) {
                    String answerText = line.trim();
                    Answer answer = new Answer(answerNumber, answerText);
                    answersList.add(answer);
                    answerNumber++;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return answersList;
    }
}

