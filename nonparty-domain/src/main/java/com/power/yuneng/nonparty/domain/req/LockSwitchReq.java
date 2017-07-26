package com.power.yuneng.nonparty.domain.req;

/**
 * Created by wuhun on 2017/5/17.
 */
public class LockSwitchReq extends BaseReq{

    /**
     * 充电桩IEMI
     */
    private String   device_id;

    /**
     * 卡槽ID
     */
    private int  slot_no;

    /**
     * 开闭锁类型
     0：人工操作
     1：借电
     2：还电
     */
    private int type=1;

    /**
     *卡槽门开关
     0：关闭
     1：打开
     */
    private Integer slot_switch;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getSlot_switch() {
        return slot_switch;
    }

    public void setSlot_switch(Integer slot_switch) {
        this.slot_switch = slot_switch;
    }
}
