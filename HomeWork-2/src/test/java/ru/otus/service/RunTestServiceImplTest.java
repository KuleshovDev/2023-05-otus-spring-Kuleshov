package ru.otus.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RunTestServiceImplTest {

    @Mock
    private PrintService printService;

    private RunTestServiceImpl runTestService;

    @BeforeEach
    public void setUp() {
        runTestService = new RunTestServiceImpl(printService);
    }

    @Test
    public void testRunTest() {
        runTestService.runTest();
        Mockito.verify(printService).printTest();
    }
}