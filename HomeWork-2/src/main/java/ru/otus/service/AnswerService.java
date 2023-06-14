package ru.otus.service;

import ru.otus.model.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> getAnswersFromCSVFile();
}