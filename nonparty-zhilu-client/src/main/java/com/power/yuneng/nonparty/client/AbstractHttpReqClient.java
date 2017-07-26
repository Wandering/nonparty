package com.power.yuneng.nonparty.client;

import com.power.yuneng.nonparty.domain.req.BaseReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhun on 2017/5/17.
 */
@Component
public abstract class AbstractHttpReqClient implements IHttpReqClient {

    private final static Logger logger = LoggerFactory.getLogger(AbstractHttpReqClient.class);

    private int count = 3;
    @Autowired
    RestTemplate restTemplate;


    @Override
    public <D, T extends BaseReq> D execute(T arg, Class<D> clazz) {
        HttpHeaders httpHeaders = new HttpHeaders();
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.ALL);
        httpHeaders.setAccept(list);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ResponseEntity<D> responseEntity = null;
        int count = this.count;
        D rtnObj = null;
        //断线重连3次
        do {
            count--;
            responseEntity = restTemplate.postForEntity(String.format(arg.getUrl(),arg.getToken()), new HttpEntity<T>(arg,httpHeaders), clazz);
        } while (responseEntity.getStatusCodeValue() != 200 && count != 0);
        //尝试转换对象
        if (responseEntity.getStatusCodeValue() == 200) {
            if (responseEntity.hasBody()) {
                rtnObj = responseEntity.getBody();
                logger.debug("知路反馈原始参数为:%s", rtnObj);
            }
        }
        return rtnObj;
    }
}
