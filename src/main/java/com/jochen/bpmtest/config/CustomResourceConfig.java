package com.jochen.bpmtest.config;

import org.camunda.bpm.engine.rest.impl.CamundaRestResources;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;
import java.util.Set;

/**
 * Created by jochen on 23May16.
 */

@Configuration
@ApplicationPath("/camunda")
public class CustomResourceConfig extends ResourceConfig{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CustomResourceConfig() {
        logger.info("CustomResourceConfig constructor called ...");
        Set<Class<?>> resourceClasses = CamundaRestResources.getResourceClasses();
        Set<Class<?>> configurationClasses = CamundaRestResources.getConfigurationClasses();
        registerClasses(resourceClasses);
        registerClasses(configurationClasses);
//        packages("org.camunda.bpm.engine.rest");
    }
}
