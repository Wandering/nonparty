package com.power.yuneng.nonparty.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/20.
 */
@Component
public class SimpleResponseErrorHandler implements ResponseErrorHandler {
    Logger logger = LoggerFactory.getLogger(SimpleResponseErrorHandler.class);
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return true;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
    }
}
