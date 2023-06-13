package ru.otus.service;

public class RunTestServiceImpl implements RunTestService {

    private final PrintService printService;

    public RunTestServiceImpl(PrintService printService) {
        this.printService = printService;
    }

    @Override
    public void runTest() {
        printService.printTest();
    }
}

