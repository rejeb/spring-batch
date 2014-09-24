package com.sofrecom.batch.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.stereotype.Component;

/**
 *
 * @author s.ouertani
 */
@Component("genericLoggerListener")
public class GenericLoggerListener {

    private Logger LOGGER = LoggerFactory.getLogger(GenericLoggerListener.class);
   
    @BeforeStep
    public void beforeStep(StepExecution se) {
        LOGGER.info("step {} has been started", se.getStepName());
    }

    @AfterStep
    public ExitStatus afterStep(StepExecution se) {
        LOGGER.info("step {} has been stopped with \n {} ", se.getStepName(), se.getSummary());
        return se.getExitStatus();
    }

    @BeforeJob
    public void beforeJob(JobExecution je) {
        LOGGER.info("job {} has been started", je.getJobId());
    }

    @AfterJob
    public void afterJob(JobExecution je) {
        LOGGER.info("job {} has been stopped with  status  {} ", je.getJobId(), je.getStatus());
       
    }

    @BeforeChunk
    public void beforeChunk() {
      // TO DO 
    }

    @AfterChunk
    public void afterChunk() {
       // TO DO 
    }

}
