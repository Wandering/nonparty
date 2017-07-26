package com.power.yuneng.nonparty.domain.req;

import java.util.List;


/**
 * Created by wuhun on 2017/5/17.
 */
public class PropertyReq extends BaseReq {

    /**
     * MIA平台产品编号
     */
    private String product;

    /**
     * 充电桩IMEI，最多支持10个充电桩，如果该参数不携带，标识修改产品下所有充电桩
     */
    private List<String> devices;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性值
     */
    private String value;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
