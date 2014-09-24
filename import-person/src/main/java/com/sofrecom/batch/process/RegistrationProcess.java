/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.process;

import com.sofrecom.batch.entity.Contact;
import com.sofrecom.batch.entity.RegistrationConfirmation;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author r.benrejeb
 */
@Component(value = "registrationProcess")
public class RegistrationProcess {

    public RegistrationConfirmation process(Contact contact) {

        return new RegistrationConfirmation(contact, Boolean.TRUE, new Date());
    }
}
