package ru.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.dao.DataFromResourceFileDao;
import ru.otus.dao.DataFromResourceFileDaoImpl;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class DaoConfig {

    @Value("${csv.file.path}")
    private  String csvFile;

    @Bean
    public DataFromResourceFileDao dataFromResourceFileDao() {
        return new DataFromResourceFileDaoImpl(csvFile);
    }
}
