package com.jochen.bpmtest;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Created by jochen on 29May16.
 */
public class TaskCompletedListener implements ExecutionListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        logger.info("TaskCompletedListener Task " + execution.getCurrentActivityName() + " completed");
        DelegateExecution processInstance = execution.getProcessInstance();
        VariableMap variables = processInstance.getVariablesTyped();
        Set<String> keySet = variables.keySet();
        for (String key : keySet) {
            TypedValue valueTyped = variables.getValueTyped(key);
            if(key.equals("flightEvent")){
                ObjectValue objectValue = (ObjectValue) valueTyped;
                FlightEvent flightEvent = objectValue.getValue(FlightEvent.class);
                logger.info("key: " + key + " value: " + flightEvent.toString());
            }
            else {
                logger.info("key: " + key + " value: " + valueTyped.toString());
            }
        }
    }
}
