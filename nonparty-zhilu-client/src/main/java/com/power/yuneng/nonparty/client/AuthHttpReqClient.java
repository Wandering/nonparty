package com.power.yuneng.nonparty.client;


import com.alibaba.fastjson.JSON;
import com.power.cloud.dynclient.DynConfigClient;
import com.power.cloud.dynclient.DynConfigClientFactory;
import com.power.yuneng.nonparty.domain.req.BaseReq;
import com.power.yuneng.nonparty.domain.res.BaseRes;
import com.power.yuneng.nonparty.domain.res.TokenRes;
import com.power.yuneng.nonparty.cache.IRedisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * Created by wuhun on 2017/5/17.
 * 知路服务器认证client
 */
@Service
public class AuthHttpReqClient extends AbstractHttpReqClient implements IHttpReqClient{
    //知路服务器

    //获取token地址
    private final static Logger logger = LoggerFactory.getLogger(AuthHttpReqClient.class);
    private static final DynConfigClient dynConfigClient = DynConfigClientFactory.getClient();
    private final static String TOKEN_ZHILU = "TOKEN_ZHILU";
    @Autowired
    @Qualifier("redisRepository")
    private IRedisRepository<String,String> redis;
    //断线错误码
    private final static int[] error_code = {60003, 60004, 60005};


    /**
     * 获取token
     *
     * @return
     */
    private String getToken() {

        redis.del(TOKEN_ZHILU);
        String token = null;
        BaseReq baseReq = null;
        try {
            baseReq = new BaseReq();
            baseReq.setUrl(dynConfigClient.getConfig("configs","host") + dynConfigClient.getConfig("configs","queryTokenUrl"));
            baseReq.setUserid(dynConfigClient.getConfig("configs","zhiluUserId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        TokenRes tokenRes = execute(baseReq, TokenRes.class);
        token = tokenRes.getToken();
        redis.set(TOKEN_ZHILU,token,7, TimeUnit.DAYS);
        return token;
    }

    public String getCacheToken() {
        return redis.get(TOKEN_ZHILU);
    }
    /**
     * 自动认证体系
     *
     * @param <T>
     * @return
     */
    public  <T extends BaseRes,D extends BaseReq> T auth(D url, T res, Class<T> clazz) {
        boolean flag = false;
        Integer errcode = 0;
        for (int error : error_code) {
            //如果错误码在这三个之间

            flag = res.getErrcode()== error;
            if (flag){
                errcode = error;
                break;
            }
        }
        logger.debug("当前错误码:%d,确认重发请求：%s",errcode,flag);
        if (flag) {
            logger.debug("上次请求结果为:%s", JSON.toJSONString(res));
            //重新认证并重发请求
            String token = getToken();
            logger.debug("重新获取认证token,当前token为：%s",token);
            url.setToken(token);
            logger.debug("正在重发请求...");
            res = execute(url, clazz);
            logger.debug("重连后请求结果为:%s",JSON.toJSONString(res));
        }
        return res;
    }

}
