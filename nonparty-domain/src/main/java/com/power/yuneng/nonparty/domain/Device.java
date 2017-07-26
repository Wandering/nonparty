package com.power.yuneng.nonparty.domain;

import java.io.Serializable;

/**
 * Created by wuhun on 2017/5/17.
 */
public class Device implements Serializable{
    /**
     * 充电桩IMEI编号
     */
    private String devid;

    /**
     * 充电桩名称
     */
    private String name;

    /**
     * 所属产品
     */
    private String product;

    /**
     * protocol
     * 通讯协议
     HTTP：0
     HTTPS：1
     MQTT：2
     COAP：3
     */
    private int protocol;

    /**
     * 充电桩状态
     */
    private int status;

    /**
     * 登录时间
     */
    private String LoginTime;

    /**
     * 下线时间
     */
    private String LogoutTime;

    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(String loginTime) {
        LoginTime = loginTime;
    }

    public String getLogoutTime() {
        return LogoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        LogoutTime = logoutTime;
    }
}
