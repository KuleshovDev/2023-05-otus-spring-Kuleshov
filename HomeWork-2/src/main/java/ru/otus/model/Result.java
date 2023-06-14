package ru.otus.model;

public class Result {

    private Integer result;

    private Student student;

    public Result(Integer result, Student student) {
        this.result = result;
        this.student = student;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Test results: " +
               "points scored: " + result +
               ", student: " + student;
    }
}
