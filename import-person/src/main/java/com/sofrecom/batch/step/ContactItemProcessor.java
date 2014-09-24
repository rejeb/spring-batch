/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.step;

import com.sofrecom.batch.entity.Contact;
import com.sofrecom.batch.entity.RegistrationConfirmation;
import com.sofrecom.batch.process.RegistrationProcess;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author r.benrejeb
 */
@Component(value = "contactItemProcessor")
@Scope(value = "step")
public class ContactItemProcessor implements
        ItemProcessor<Contact, RegistrationConfirmation> {
    @Autowired(required = true)
    @Qualifier("registrationProcess")
    private RegistrationProcess registrationProcess;
    
	@Value("#{stepExecutionContext[name]}")
	private String threadName;
    @Override
    public RegistrationConfirmation process(Contact item)
            throws Exception {
        item.setThreadName(Thread.currentThread().getName());
        RegistrationConfirmation confirmation=registrationProcess.process(item);
//     if(item.getFirstname().equals("Kiam")) {
//                   item.setFirstname("kiam");
//        throw new RuntimeException();
//               }
        return confirmation;
    }

    public RegistrationProcess getRegistrationProcess() {
        return registrationProcess;
    }

    public void setRegistrationProcess(RegistrationProcess registrationProcess) {
        this.registrationProcess = registrationProcess;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
                System.out.println("threadName:"+threadName);
    }
    
}
