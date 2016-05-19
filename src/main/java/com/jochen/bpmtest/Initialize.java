package com.jochen.bpmtest;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.VariableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

/**
 * Created by jochen on 19May16.
 */
public class Initialize implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("Initalize called");
        DelegateExecution processInstance = execution.getProcessInstance();
        VariableMap variables = processInstance.getVariablesTyped();
        Set<String> keySet = variables.keySet();
        for(String key: keySet){
            logger.info("key: " + key + " value: " + variables.getValueTyped(key).toString());
        }
        execution.setVariable("manual", true);
    }
}
