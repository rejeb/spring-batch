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
@Component("itemFailureLoggerListener")
public class ItemFailureLoggerListener extends ItemListenerSupport {

    private static Logger logger = LoggerFactory.getLogger(ItemFailureLoggerListener.class);    

    @Override
    public void onReadError(Exception ex) {
        ex.printStackTrace();
        logger.error("Encountered error on read", ex.toString());
    }
    
    @Override
    public void onWriteError(Exception ex, List item) {
        logger.error("Encountered error on write", ex.toString());
    }

    
    @Override
    public void onProcessError(Object item, Exception e) {
       logger.error("onProcessError {}", item,e.toString());
    }

   
}