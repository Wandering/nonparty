package com.power.yuneng.nonparty.client;

import com.power.yuneng.nonparty.domain.req.BaseReq;

/**
 * Created by wuhun on 2017/5/17.
 */
public interface IHttpReqClient{
    <D, T extends BaseReq> D execute(T arg, Class<D> clazz);
}
