package com.jochen.bpmtest.config;

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.configuration.CamundaDatasourceConfiguration;
import org.postgresql.jdbc3.Jdbc3SimpleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by jochen on 28May16.
 */
public class CustomCamundaDatasourceConfiguration implements CamundaDatasourceConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CustomCamundaDatasourceConfiguration() {
        logger.info("CustomCamundaDatasourceConfiguration constructor called ...");
    }

    @Override
    public void apply(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        DataSource dataSource = new SimpleDriverDataSource();
        ((SimpleDriverDataSource)dataSource).setDriverClass(org.postgresql.Driver.class);
        ((SimpleDriverDataSource)dataSource).setUrl("jdbc:postgresql://localhost:5432/camunda");
        ((SimpleDriverDataSource)dataSource).setUsername("jochen");
        ((SimpleDriverDataSource)dataSource).setPassword("jotanja");
        springProcessEngineConfiguration.setDataSource(dataSource);
        springProcessEngineConfiguration.setTransactionManager(new DataSourceTransactionManager(dataSource));
        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
    }
}
