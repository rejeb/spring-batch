/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.step;

import com.sofrecom.batch.entity.RegistrationConfirmation;
import com.sofrecom.batch.service.RegistrationConfirmationService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author r.benrejeb
 */
@Component(value = "registrationDBWriter")
@Scope(value = "step")
public class RegistrationConfirmationWriter implements ItemWriter<RegistrationConfirmation> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationConfirmationWriter.class);
    @Autowired
    RegistrationConfirmationService confirmationService;
	@Value("#{stepExecutionContext[name]}")
	private String threadName;
    @Override
    public void write(List<? extends RegistrationConfirmation> items) throws Exception {
        for (RegistrationConfirmation item : items) {
            confirmationService.add(item);
            LOGGER.info("writing " + item);
        }
        LOGGER.info("Chunck complete.");
//        throw new RuntimeException();
        
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
         LOGGER.info("threadName:"+threadName);
    }
    
    
}
