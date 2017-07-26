package com.power.yuneng.nonparty.domain;

/**
 * Created by Administrator on 2017/5/22.
 */
public enum LockTypeEnum {
//    开闭锁类型
//0：人工操作
//1：借电
//2：还电
    BORROW(1)
    ;
    private final Integer code;

    LockTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
