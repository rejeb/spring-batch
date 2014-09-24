/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.mapper;

import com.sofrecom.batch.entity.Contact;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 *
 * @author r.benrejeb
 */
public class ContactFieldSetMapper implements FieldSetMapper<Contact> {
@Override
public Contact mapFieldSet(FieldSet fieldSet) throws BindException {
    Contact contact=new Contact(
fieldSet.readString(0),
fieldSet.readString(1),
fieldSet.readDate(2,"yyyy-MM-dd")
);          
return contact;
}
}
