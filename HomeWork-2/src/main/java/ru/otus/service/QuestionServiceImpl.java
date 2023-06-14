package ru.otus.service;

import org.springframework.stereotype.Component;
import ru.otus.dao.DataFromResourceFileDao;
import ru.otus.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionServiceImpl implements QuestionService {

    private final DataFromResourceFileDao dataFromResourceFileDao;

    public QuestionServiceImpl(DataFromResourceFileDao dataFromResourceFileDao) {
        this.dataFromResourceFileDao = dataFromResourceFileDao;
    }

    @Override
    public List<Question> getQuestionsFromCSVFile() {
        List<Question> questionsList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(dataFromResourceFileDao.getDataFromResourceFile()));
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
