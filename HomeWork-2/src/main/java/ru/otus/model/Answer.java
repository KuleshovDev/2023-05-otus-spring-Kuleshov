package ru.otus.model;

public class Answer {

    private Integer id;

    private String answer;

    private Integer correctNumber;

    public Answer(Integer id, String answer, Integer correctNumber) {
        this.id = id;
        this.answer = answer;
        this.correctNumber = correctNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getCorrectNumber() {
        return correctNumber;
    }

    public void setCorrectNumber(Integer correctNumber) {
        this.correctNumber = correctNumber;
    }
}