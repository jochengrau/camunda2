package com.jochen.bpmtest;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jochen on 19May16.
 */
public class CompleteUserTaskListener implements TaskListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void notify(DelegateTask delegateTask) {
        logger.info("CompleteUserTaskListener: " + delegateTask.toString());
    }
}
