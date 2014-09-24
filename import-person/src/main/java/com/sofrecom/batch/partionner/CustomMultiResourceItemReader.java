/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.partionner;
import java.lang.reflect.Field;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.core.io.Resource;
 
public class CustomMultiResourceItemReader extends MultiResourceItemReader<List > {
 
  private static final Logger log = LoggerFactory.getLogger(CustomMultiResourceItemReader.class.getName());
 
  @Override
  public void open(ExecutionContext executionContext) throws ItemStreamException {
 
    super.open(executionContext);
 
    try {
 
      Field resourcesField = MultiResourceItemReader.class.getDeclaredField("resources");
      resourcesField.setAccessible(true);
      Resource[] resources = (Resource[]) resourcesField.get(this);
 
      executionContext.put("current.resource.name", resources[0].getFilename());
 
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
 
  @Override
  public void update(ExecutionContext executionContext) throws ItemStreamException {
 
    super.update(executionContext);
 
    try {
 
      Field indexField = MultiResourceItemReader.class.getDeclaredField("index");
      indexField.setAccessible(true);
      Object index = indexField.get(this);
 
      Field currentResourceField = index.getClass().getDeclaredField("currentResource");
      currentResourceField.setAccessible(true);
      Integer currentResource = (Integer)currentResourceField.get(index);
 
      Field resourcesField = MultiResourceItemReader.class.getDeclaredField("resources");
      resourcesField.setAccessible(true);
      Resource[] resources = (Resource[]) resourcesField.get(this);
 
      if (currentResource < resources.length) {
          executionContext.put("current.resource.name", resources[currentResource].getFile().getPath());
      } else {
          executionContext.put("current.resource.name", null);
      }
 
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
 
}