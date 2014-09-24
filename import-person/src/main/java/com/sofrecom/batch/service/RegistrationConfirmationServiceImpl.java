/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.service;

import com.sofrecom.batch.entity.RegistrationConfirmation;
import com.sofrecom.batch.repository.RegistrationConfirmationRepository;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author r.benrejeb
 */
@Service(value = "confirmationService")
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.DEFAULT)
public class RegistrationConfirmationServiceImpl implements RegistrationConfirmationService {
    
@Autowired
RegistrationConfirmationRepository confirmationRepository;

@Override
        public void add(RegistrationConfirmation confirmation) {
       confirmationRepository.save(confirmation);
    }
    
}
