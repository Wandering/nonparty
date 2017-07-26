package com.power.yuneng.nonparty.domain.req;

/**
 * Created by wuhun on 2017/5/17.
 */
public class StationReq extends BaseReq{
    /**
     * 充电桩IMEI编号
     */
    private String devid;


    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid;
    }
}
