package ru.otus.service;

import java.io.InputStream;

public class DataFromResourceFileServiceImpl implements DataFromResourceFileService {
    private final String file;

    public DataFromResourceFileServiceImpl(String file) {
        this.file = file;
    }

    @Override
    public InputStream getDataFromResourceFile() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResourceAsStream(file);
    }
}
