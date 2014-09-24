/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.mapper;

import com.sofrecom.batch.entity.Contact;
import com.sofrecom.batch.entity.RegistrationConfirmation;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 *
 * @author r.benrejeb
 */
public class RegistrationFieldSetMapper
        implements FieldSetMapper<RegistrationConfirmation> {

    @Override
    public RegistrationConfirmation mapFieldSet(FieldSet fieldSet) throws BindException {
        Integer contactId=fieldSet.readString(0)!=null&&!fieldSet.readString(0).isEmpty()?fieldSet.readInt(0):null;
        Contact contact = new Contact(contactId,
                fieldSet.readString(1),
                fieldSet.readString(2),
                fieldSet.readString(4),
                fieldSet.readDate(3, "yyyy-MM-dd"));
        RegistrationConfirmation confirmation = new RegistrationConfirmation(contact,fieldSet.readBoolean(5),
                fieldSet.readDate(6)
        );
        return confirmation;
    }
}
