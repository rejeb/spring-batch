/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.step;

import com.sofrecom.batch.mapper.ContactFieldSetMapper;
import org.springframework.batch.item.file.FlatFileItemReader;

/**
 *
 * @author r.benrejeb
 */
public class FileReader extends FlatFileItemReader<ContactFieldSetMapper>{
    private int from,to;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
   
}
