package com.jochen.bpmtest.rest;

import com.jochen.bpmtest.FlightEvent;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static org.camunda.spin.Spin.JSON;

/**
 * Created by jochen on 23May16.
 */
@RestController
@RequestMapping(value = "/bpm")
public class WorkFlowController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(@RequestParam(value = "name", defaultValue = "Camunda") String name){
        return "Hello " + name;
    }

    @RequestMapping(value = "/wfstart", method = RequestMethod.PUT)
    public String startWorkflow(@RequestParam(value = "wfname") String wfName,
                                @RequestParam(value = "manual", defaultValue = "true") Boolean manual,
                                @RequestParam(value = "airline", defaultValue = "DLH") String airline){
        FlightEvent flightEvent = new FlightEvent(airline, 400, new Date(), new Date(), "A380", "EDDF", "EDDM");
        ObjectValue objectValue = Variables.objectValue(flightEvent).serializationDataFormat("application/json").create();
        VariableMap variableMap = Variables.createVariables()
                .putValueTyped("flightEvent", objectValue)
                .putValueTyped("manual", Variables.booleanValue(manual));
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(wfName, variableMap);
        return processInstance.getProcessInstanceId();
    }

    @RequestMapping(value = "/humanTasks", method = RequestMethod.GET)
    public String getHumanTaskList(){
        List<Task> taskList = taskService.createTaskQuery().list();
        StringBuilder stringBuilder = new StringBuilder();
        for(Task task: taskList){
//            stringBuilder.append(JSON(task).toString());
            stringBuilder.append(task.toString()).append("\n");
        }
        return stringBuilder.toString();
//        return taskList.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}
