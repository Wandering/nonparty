package com.power.yuneng.nonparty.client;

import com.power.cloud.dynclient.DynConfigClient;
import com.power.cloud.dynclient.DynConfigClientFactory;
import com.power.yuneng.nonparty.domain.res.BaseRes;
import com.power.yuneng.nonparty.domain.res.QueryPowerRes;
import com.power.yuneng.nonparty.domain.res.RegisterRes;
import com.power.yuneng.nonparty.domain.res.StationBaseRes;
import com.power.yuneng.nonparty.api.IPowerConsumer;
import com.power.yuneng.nonparty.domain.req.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wuhun on 2017/5/17.
 */
@Service
public class HttpConsumerClient extends AbstractHttpReqClient implements IHttpReqClient,IPowerConsumer {
    private static final Logger logger = LoggerFactory.getLogger(HttpConsumerClient.class);

    private static final DynConfigClient dynConfigClient = DynConfigClientFactory.getClient();
    @Autowired
    private AuthHttpReqClient authHttpReqClient;

    private HttpConsumerClient(){}


    private <T extends BaseReq>void setUserIdAndToken(T req){
        try {
            req.setUserid(dynConfigClient.getConfig("configs","zhiluUserId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String token = authHttpReqClient.getCacheToken();
//        String token = "e5a31475420cc4f489abd0af4e6a78f0";
        req.setToken(token);
    }

    @Override
    public RegisterRes registerPower(RegisterReq req) {
        setUserIdAndToken(req);
        try {
            req.setUrl(dynConfigClient.getConfig("configs", "host") + dynConfigClient.getConfig("configs", "addUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        RegisterRes res = execute(req, RegisterRes.class);
        return authHttpReqClient.auth(req, res, RegisterRes.class);
    }

    @Override
    public QueryPowerRes queryPower(QueryPowerReq req) {
        setUserIdAndToken(req);
        try {
            req.setUrl(dynConfigClient.getConfig("configs","host")+dynConfigClient.getConfig("configs","queryUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        QueryPowerRes res = execute(req,QueryPowerRes.class);
        return authHttpReqClient.auth(req,res,QueryPowerRes.class);
    }

    @Override
    public BaseRes delStation(StationReq req) {
        setUserIdAndToken(req);
        try {
            req.setUrl(dynConfigClient.getConfig("configs","host")+dynConfigClient.getConfig("configs","delUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseRes res = execute(req,BaseRes.class);
        return authHttpReqClient.auth(req,res,BaseRes.class);
    }

    @Override
    public BaseRes disStation(DisableReq req) {
        setUserIdAndToken(req);
        try {
            req.setUrl(dynConfigClient.getConfig("configs","host")+dynConfigClient.getConfig("configs","devstateUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseRes res = execute(req,BaseRes.class);
        return authHttpReqClient.auth(req,res,BaseRes.class);
    }

    @Override
    public StationBaseRes lockSwich(LockSwitchReq req) {
        setUserIdAndToken(req);
        try {
            req.setUrl(dynConfigClient.getConfig("configs","host")+dynConfigClient.getConfig("configs","lockSwitcUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        StationBaseRes res = execute(req,StationBaseRes.class);
        logger.debug("第一次调用结果:%s,异常码为:%s",res.getErrcode()==0,res.getErrcode());
        return authHttpReqClient.auth(req,res,StationBaseRes.class);
    }

    @Override
    public StationBaseRes preBorrow(StationReq req) {
        setUserIdAndToken(req);
        try {
            req.setUrl(dynConfigClient.getConfig("configs","host")+dynConfigClient.getConfig("configs","preBorrowUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        StationBaseRes res = execute(req,StationBaseRes.class);
        logger.debug("第一次调用结果:%s,异常码为:%s",res.getErrcode()==0,res.getErrcode());
        res = authHttpReqClient.auth(req,res,StationBaseRes.class);
        return res;
    }

    @Override
    public BaseRes confProperty(PropertyReq req) {
        setUserIdAndToken(req);
        try {
            req.setUrl(dynConfigClient.getConfig("configs","host")+dynConfigClient.getConfig("configs","configureUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseRes res = execute(req,BaseRes.class);
        return authHttpReqClient.auth(req,res,BaseRes.class);
    }

    @Override
    public BaseRes uploadStation(UploadReq req) {
        setUserIdAndToken(req);
        try {
            req.setUrl(dynConfigClient.getConfig("configs","host")+dynConfigClient.getConfig("configs","upgradeUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseRes res = execute(req,BaseRes.class);
        return authHttpReqClient.auth(req,res,BaseRes.class);
    }

}
