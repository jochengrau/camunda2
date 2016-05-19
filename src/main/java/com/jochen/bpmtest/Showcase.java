package com.jochen.bpmtest;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class Showcase {

  private final Logger logger = getLogger(this.getClass());

  @Autowired
  private RuntimeService runtimeService;

  @Autowired
  private TaskService taskService;

  private String processInstanceId;

  @EventListener
  public void notify(final ContextRefreshedEvent unused) {
    VariableMap variableMap = Variables.createVariables()
            .putValueTyped("first", Variables.stringValue("firstParam"))
            .putValueTyped("second", Variables.booleanValue(true))
            .putValueTyped("third", Variables.dateValue(new Date()))
            .putValueTyped("fourth", Variables.integerValue(4));
    processInstanceId = runtimeService.startProcessInstanceByKey("Test_1", variableMap).getProcessInstanceId();
    logger.info("started instance: {}", processInstanceId);

//    Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
//    taskService.complete(task.getId());
//    logger.info("completed task: {}", task);

    // now jobExecutor should execute the async job
  }

  public String getProcessInstanceId() {
    return processInstanceId;
  }
}
