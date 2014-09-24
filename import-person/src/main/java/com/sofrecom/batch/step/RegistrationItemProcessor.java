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
@Component(value = "registrationItemProcessor")
@Scope(value = "step")
public class RegistrationItemProcessor implements
        ItemProcessor<RegistrationConfirmation, RegistrationConfirmation> {
  
    
	@Value("#{stepExecutionContext[name]}")
	private String threadName;
    @Override
    public RegistrationConfirmation process(RegistrationConfirmation item)
            throws Exception {
        item.getContact().setThreadName(item.getContact().getThreadName()+"--"+Thread.currentThread().getName());
       
//     if(item.getFirstname().equals("Kiam")) {
//                   item.setFirstname("kiam");
//        throw new RuntimeException();
//               }
        return item;
    }

   
    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
                System.out.println("threadName:"+threadName);
    }
    
}
