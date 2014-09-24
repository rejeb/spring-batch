/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.listener.SkipListenerSupport;

/**
 *
 * @author r.benrejeb
 */
public class Slf4jSkipListener<T,S> extends SkipListenerSupport<T, S> {
private static final Logger LOG = LoggerFactory.getLogger(
Slf4jSkipListener.class);
@Override
public void onSkipInRead(Throwable t) {
    LOG.error("skipped item: {}",t.toString());
    LOG.error("skipped item cause: {}",t.getCause().toString());
}
    
}
