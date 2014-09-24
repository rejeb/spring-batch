package com.sofrecom.batch.listeners;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.listener.ItemListenerSupport;
import org.springframework.stereotype.Component;

/**
 *
 * @author s.ouertani
 */
@Component("itemLoggerListener")
public class ItemLoggerListener extends ItemListenerSupport {

    private static Logger logger = LoggerFactory.getLogger(ItemLoggerListener.class);    

   

    @Override
    public void afterRead(Object item) {
        logger.info("afterRead {}", item);
    }

    @Override
    public void beforeRead() {
        logger.info("beforeRead");
    }

    @Override
    public void afterProcess(Object item, Object result) {
       logger.info("afterProcess {} => result {}", item, result);
    }

    @Override
    public void beforeProcess(Object item) {
       logger.info("beforeProcess {}", item);
    }

 

    @Override
    public void afterWrite(List item) {
       logger.info("afterWrite {}", item);
    }

    @Override
    public void beforeWrite(List item) {
        logger.info("beforeWrite {}", item);
    }
}