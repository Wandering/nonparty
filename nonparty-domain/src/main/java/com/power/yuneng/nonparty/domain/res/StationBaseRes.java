package com.power.yuneng.nonparty.domain.res;


/**
 * Created by wuhun on 2017/5/17.
 */
public class StationBaseRes extends BaseRes{
    /**
     * 充电宝ID，错误响应、卡槽空无需携带
     */
    private String battery_id;
    /**
     * 开闭锁时间，错误响应时无需携带
     */
    private Long time;

    private int slot_no;

    public String getBattery_id() {
        return battery_id;
    }


    public void setBattery_id(String battery_id) {
        this.battery_id = battery_id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }
}
