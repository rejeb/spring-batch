/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.step;

import com.sofrecom.batch.entity.RegistrationConfirmation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

/**
 *
 * @author r.benrejeb
 */
public class StringItemWriter implements ItemWriter<String> {
private static final Logger LOGGER =LoggerFactory.getLogger(StringItemWriter.class);

@Override
public void write(List<? extends String> items) throws Exception {
for(String item : items) {
LOGGER.info("writing "+item);
}
LOGGER.info("Chunck complete.");
}
    
}
