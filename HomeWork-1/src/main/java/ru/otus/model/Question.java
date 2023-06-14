package ru.otus.model;

public class Question {

    private Integer id;

    private String question;

    public Question(Integer id, String question) {
        this.id = id;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
