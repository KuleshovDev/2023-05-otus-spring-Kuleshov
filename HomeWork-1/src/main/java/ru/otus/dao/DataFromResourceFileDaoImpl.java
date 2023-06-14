package ru.otus.dao;

import java.io.InputStream;

public class DataFromResourceFileDaoImpl implements DataFromResourceFileDao {
    private final String file;

    public DataFromResourceFileDaoImpl(String file) {
        this.file = file;
    }

    @Override
    public InputStream getDataFromResourceFile() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResourceAsStream(file);
    }
}
