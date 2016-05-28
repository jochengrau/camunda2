package com.jochen.bpmtest;
//
//import org.camunda.bpm.engine.HistoryService;
//import org.camunda.bpm.engine.RuntimeService;
//import org.camunda.bpm.engine.TaskService;
//import org.camunda.bpm.engine.history.HistoricProcessInstance;
//import org.camunda.bpm.engine.task.Task;
//import org.camunda.bpm.engine.variable.VariableMap;
//import org.camunda.bpm.engine.variable.Variables;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ExitCodeGenerator;
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.Map;
//
//import static org.slf4j.LoggerFactory.getLogger;
//
//@Component
//public class Showcase {
//
//    private final Logger logger = getLogger(this.getClass());
//
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private HistoryService historyService;
//
//    @Autowired
//    private ConfigurableApplicationContext context;
//
//    private String processInstanceId;
//
//    public Showcase() {
//        logger.info("Showcase constructor called ...");
//    }
//
////    @EventListener
////    public void notify(final ContextRefreshedEvent unused) {
////        VariableMap variableMap = Variables.createVariables()
////                .putValueTyped("first", Variables.stringValue("firstParam"))
////                .putValueTyped("second", Variables.booleanValue(true))
////                .putValueTyped("third", Variables.dateValue(new Date()))
////                .putValueTyped("fourth", Variables.integerValue(4));
////        processInstanceId = runtimeService.startProcessInstanceByKey("Test_1", variableMap).getProcessInstanceId();
////        logger.info("started instance: {}", processInstanceId);
////
//////    Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
//////    taskService.complete(task.getId());
//////    logger.info("completed task: {}", task);
////
////        // now jobExecutor should execute the async job
////    }
//
//    public String getProcessInstanceId() {
//        return processInstanceId;
//    }
//
////    @Scheduled(fixedDelay = 1500L)
////    public void exitApplicationWhenProcessIsFinished() {
////        String processInstanceId = this.getProcessInstanceId();
////
////        if (processInstanceId == null) {
////            logger.info("processInstance not yet started!");
////            return;
////        }
////
////        if (isProcessInstanceFinished()) {
////            logger.info("processinstance ended!");
////
////            SpringApplication.exit(context, new ExitCodeGenerator() {
////
////                @Override
////                public int getExitCode() {
////                    return 0;
////                }
////            });
////            return;
////        }
////        logger.info("processInstance not yet ended!");
////    }
//
//    public boolean isProcessInstanceFinished() {
//        final HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
//                .processInstanceId(this.getProcessInstanceId())
//                .singleResult();
//
//        return historicProcessInstance != null && historicProcessInstance.getEndTime() != null;
//
//    }
//}
