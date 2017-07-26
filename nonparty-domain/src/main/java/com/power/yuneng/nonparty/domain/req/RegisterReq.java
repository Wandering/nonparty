package com.power.yuneng.nonparty.domain.req;

import java.util.List;

/**
 * Created by wuhun on 2017/5/17.
 */
public class RegisterReq extends BaseReq {
    private String name; // 充电桩名称

    private String product; //所属产品

    /**
     * HTTP：0
     HTTPS：1
     MQTT：2
     COAP：3
     */
    private int protocol = 2; //通讯协议

    private List<String> devices; //充电桩IMEI编号

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }
}
