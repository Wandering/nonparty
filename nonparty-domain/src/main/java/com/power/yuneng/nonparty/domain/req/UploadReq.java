package com.power.yuneng.nonparty.domain.req;

import java.util.List;

/**
 * Created by wuhun on 2017/5/17.
 */
public class UploadReq extends BaseReq{
    /**
     * 充电桩IMEI，最多支持10个充电桩，如果该参数不携带，标识修改产
     */
    private List<String> devices;

    /**
     * 版本号，预留字段
     */
    private String version;

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
