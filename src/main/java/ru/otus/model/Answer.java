package ru.otus.model;

public class Answer {

    private Integer id;

    private String answer;

    public Answer(Integer id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
