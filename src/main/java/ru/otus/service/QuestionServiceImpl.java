package ru.otus.service;

import ru.otus.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final DataFromResourceFileService dataFromResourceFileService;

    public QuestionServiceImpl(DataFromResourceFileService dataFromResourceFileService) {
        this.dataFromResourceFileService = dataFromResourceFileService;
    }

    @Override
    public List<Question> getQuestionsFromCSVFile() {
        List<Question> questionsList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(dataFromResourceFileService.getDataFromResourceFile()));
            String line;
            int questionNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (line.contains("?")) {
                    String questionText = line.trim();
                    Question question = new Question(questionNumber, questionText);
                    questionsList.add(question);
                    questionNumber++;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionsList;
    }
}
