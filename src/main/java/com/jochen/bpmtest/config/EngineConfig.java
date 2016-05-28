package com.jochen.bpmtest.config;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.configuration.CamundaConfiguration;
import org.camunda.bpm.spring.boot.starter.configuration.CamundaDatasourceConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class EngineConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public EngineConfig() {
        logger.info("EngineConfig constructor called ...");
    }

    @Bean
    @Order(CamundaConfiguration.DEFAULT_ORDER + 1)
    public static CamundaDatasourceConfiguration camundaDatasourceConfiguration() {
        return new CustomCamundaDatasourceConfiguration();
    }

//    @Bean
//    public DataSource dataSource() {
//        // Use a JNDI data source or read the properties from
//        // env or a properties file.
//        // Note: The following shows only a simple data source
//        // for In-Memory H2 database.
//
//        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//        dataSource.setDriverClass(org.h2.Driver.class);
//        dataSource.setUrl("jdbc:h2:mem:camunda;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//    @Bean
//    public SpringProcessEngineConfiguration processEngineConfiguration() {
//        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
//
//        config.setDataSource(dataSource());
//        config.setTransactionManager(transactionManager());
//
//        config.setDatabaseSchemaUpdate("true");
//        config.setHistory("audit");
//        config.setJobExecutorActivate(true);
//
//        return config;
//    }
//
//    @Bean
//    public ProcessEngineFactoryBean processEngine() {
//        ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
//        factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
//        return factoryBean;
//    }
//
//    @Bean
//    public RepositoryService repositoryService(ProcessEngine processEngine) {
//        return processEngine.getRepositoryService();
//    }
//
//    @Bean
//    public RuntimeService runtimeService(ProcessEngine processEngine) {
//        return processEngine.getRuntimeService();
//    }
//
//    @Bean
//    public TaskService taskService(ProcessEngine processEngine) {
//        return processEngine.getTaskService();
//    }

}
