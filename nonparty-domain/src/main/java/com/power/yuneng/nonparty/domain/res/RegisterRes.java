package com.power.yuneng.nonparty.domain.res;


import java.util.List;

/**
 * Created by wuhun on 2017/5/17.
 */
public class RegisterRes extends BaseRes {
    //成功
    private List<String> devices;
    //失败
    private List<String> faileDevices;

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    public List<String> getFaileDevices() {
        return faileDevices;
    }

    public void setFaileDevices(List<String> faileDevices) {
        this.faileDevices = faileDevices;
    }
}
