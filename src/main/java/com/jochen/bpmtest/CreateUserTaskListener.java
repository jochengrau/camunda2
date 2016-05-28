package com.jochen.bpmtest;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by jochen on 19May16.
 */
public class CreateUserTaskListener implements TaskListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void notify(DelegateTask delegateTask) {
        logger.info("CreateUserTaskListener: " + delegateTask.toString());

        Task myTask = null;
        TaskService taskService = delegateTask
                .getExecution()
                .getProcessInstance()
                .getProcessEngineServices()
                .getTaskService();

        List<Task> taskList = taskService
                .createTaskQuery()
                .taskDefinitionKey(delegateTask.getTaskDefinitionKey())
                .list();
        for( Task task: taskList ){
            logger.info("task: " + task.toString());
            myTask = task;
        }
//        try {
//            Thread.sleep(500000);
//            taskService.complete(delegateTask.getId());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
