package com.jochen.bpmtest;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Created by jochen on 19May16.
 */
public class Finalize implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("Finalize called");
        DelegateExecution processInstance = execution.getProcessInstance();
        VariableMap variables = processInstance.getVariablesTyped();
        Set<String> keySet = variables.keySet();
        for (String key : keySet) {
            TypedValue valueTyped = variables.getValueTyped(key);
            if(key.equals("flightEvent")){
                ObjectValue objectValue = (ObjectValue) valueTyped;
                String valueSerialized = objectValue.getValueSerialized();
                FlightEvent flightEvent = objectValue.getValue(FlightEvent.class);
                logger.info("key: " + key + " serialized value: " + valueSerialized + " value: " + flightEvent.toString());
            }
            else {
                logger.info("key: " + key + " value: " + valueTyped.toString());
            }
        }
    }
}
