package com.jochen.bpmtest.config;

import java.util.Set;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.rest.spi.ProcessEngineProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestProcessEngineProvider implements ProcessEngineProvider {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RestProcessEngineProvider() {
        super();
        logger.info("RestProcessEngineProvider constructor called ...");
    }

    @Override
    public ProcessEngine getDefaultProcessEngine() {
        return ProcessEngines.getDefaultProcessEngine();
    }

    @Override
    public ProcessEngine getProcessEngine(String name) {
        return ProcessEngines.getProcessEngine(name);
    }

    @Override
    public Set<String> getProcessEngineNames() {
        return ProcessEngines.getProcessEngines().keySet();
    }

}
