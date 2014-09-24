/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 *
 * @author r.benrejeb
 */
public class StringItemReader implements ItemReader<String>{

    private List<String> list;
public StringItemReader() {
this.list = new ArrayList<String>(Arrays.asList(
"1","2","3","4","5","6","7")
);
}
@Override
public String read() throws Exception, UnexpectedInputException,
ParseException, NonTransientResourceException {
return !list.isEmpty() ? list.remove(0) : null;
}
    
}
