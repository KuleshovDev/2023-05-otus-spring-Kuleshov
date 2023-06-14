package ru.otus.service;

import org.springframework.stereotype.Component;
import ru.otus.dao.DataFromResourceFileDao;
import ru.otus.model.Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerServiceImpl implements AnswerService {

    private final DataFromResourceFileDao dataFromResourceFileDao;

    public AnswerServiceImpl(DataFromResourceFileDao dataFromResourceFileDao) {
        this.dataFromResourceFileDao = dataFromResourceFileDao;
    }

    @Override
    public List<Answer> getAnswersFromCSVFile() {
        List<Answer> answersList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(dataFromResourceFileDao.getDataFromResourceFile()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(";")) {
                    Answer answer = processAnswerLine(line, answersList);
                    answersList.add(answer);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answersList;
    }

    private Answer processAnswerLine(String line, List<Answer> answersList) {
        String answerText = line.trim();
        String[] answerChar = answerText.split(";");
        int indexCorrectAnswer = findCorrectAnswerIndex(answerChar);
        String answerString = answerText.replace("+", "");
        int answerNumber = answersList.size(); // Исправление
        return new Answer(answerNumber, answerString, indexCorrectAnswer);
    }

    private int findCorrectAnswerIndex(String[] answerChar) {
        for (int i = 0; i < answerChar.length; i++) {
            if (answerChar[i].contains("+")) {
                return i + 1;
            }
        }
        return 0;
    }
}
