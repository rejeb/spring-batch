/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.step;

import org.springframework.batch.item.ItemProcessor;

/**
 *
 * @author r.benrejeb
 */
public class StringItemProcessor implements ItemProcessor<String, String> {
@Override
public String process(String item) throws Exception {
return "*** "+item+" ***";
}
    
}
