package com.power.yuneng.nonparty.api;


import com.power.yuneng.nonparty.domain.req.*;
import com.power.yuneng.nonparty.domain.res.BaseRes;
import com.power.yuneng.nonparty.domain.res.QueryPowerRes;
import com.power.yuneng.nonparty.domain.res.RegisterRes;
import com.power.yuneng.nonparty.domain.res.StationBaseRes;

/**
 * Created by wuhun on 2017/5/17.
 */
public interface IPowerConsumer {
    /**
     * 注册充电桩
     * @param req
     * @return
     */
    RegisterRes registerPower(RegisterReq req);

    /**
     * 查询充电桩信息
     * @param req
     * @return
     */
    QueryPowerRes queryPower(QueryPowerReq req);

    /**
     *  删除充电桩信息
     * @param req
     * @return
     */
    BaseRes delStation(StationReq req);


    /**
     * 禁用充电桩
     * @param req
     * @return
     */
    BaseRes disStation(DisableReq req);

    /**
     *  远程开闭锁
     */
    StationBaseRes lockSwich(LockSwitchReq req);

    /**
     * 预借充电宝
     */
    StationBaseRes preBorrow(StationReq req);

    /**
     * 设置产品属性
     * @param req
     * @return
     */
    BaseRes confProperty(PropertyReq req);

    /**
     * 产品远程升级
     * @param req
     * @return
     */
    BaseRes uploadStation(UploadReq req);
}
