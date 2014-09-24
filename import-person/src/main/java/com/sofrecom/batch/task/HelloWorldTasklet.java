/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 *
 * @author r.benrejeb
 */
public class HelloWorldTasklet implements Tasklet {

    public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {
        System.out.println("Hello world!");
        return RepeatStatus.FINISHED;
    }
}
