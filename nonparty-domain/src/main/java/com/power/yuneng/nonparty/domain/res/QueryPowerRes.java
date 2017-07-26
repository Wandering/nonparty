package com.power.yuneng.nonparty.domain.res;

import com.power.yuneng.nonparty.domain.Device;

import java.util.List;

/**
 * Created by wuhun on 2017/5/17.
 */
public class QueryPowerRes extends BaseRes{

    /**
     * 总记录数
     */
    private Integer totalRows;


    private List<Device> devices;

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
