/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.stereotype.Component;

/**
 *
 * @author r.benrejeb
 */
@Component(value = "retryListener")
@Scope(value = "step")
public class Slf4jRetryListener extends RetryListenerSupport {

    private static final Logger LOG = LoggerFactory.getLogger(Slf4jRetryListener.class);

    @Override
    public <T> void onError(RetryContext context, RetryCallback<T> callback,
            Throwable throwable) {
        LOG.error("retried operation", throwable);
    }
}
