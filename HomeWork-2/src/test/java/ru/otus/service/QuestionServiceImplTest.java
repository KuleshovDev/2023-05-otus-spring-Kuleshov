package ru.otus.service;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class QuestionServiceImplTest {

    @Test
    public void testCsvFileExists() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("questionsAndAnswers.csv")).getFile());
        assertTrue(file.exists());
    }
}




