/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author r.benrejeb
 */
public class ImportLauncher {
    public void launch() throws Exception {
               ClassPathXmlApplicationContext cpt = new ClassPathXmlApplicationContext("app-context.xml");

        JobLauncher jobLauncher = (JobLauncher) cpt.getBean("jobLauncher");
		Job job = (Job) cpt.getBean("chunkProcessingJob");
JobExecution exec = jobLauncher.run(
job,
new JobParametersBuilder()
.addLong("time", System.currentTimeMillis())
.toJobParameters()
);
}
}
