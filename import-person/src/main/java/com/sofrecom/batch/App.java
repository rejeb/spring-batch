package com.sofrecom.batch;

import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext cpt = new ClassPathXmlApplicationContext("app-context.xml");
        cpt.start();
        JobParameters parameter = new JobParametersBuilder().addDate("sysDate", new Date()).toJobParameters();
        
        JobLauncher jobLauncher = (JobLauncher) cpt.getBean("jobLauncher");
        
//        Job helloWorldJob = (Job) cpt.getBean("helloWorldJob");
//        jobLauncher.run(helloWorldJob, parameter);
//        
//        Job chunkProcessingJob = (Job) cpt.getBean("chunkProcessingJob");
//        jobLauncher.run(chunkProcessingJob, parameter);
//        
        Job contactJob = (Job) cpt.getBean("contactJob");
        jobLauncher.run(contactJob, parameter);
        cpt.close();
                
    }
}
