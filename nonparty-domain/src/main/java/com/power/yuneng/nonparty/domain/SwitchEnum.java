package com.power.yuneng.nonparty.domain;

/**
 * Created by Administrator on 2017/5/22.
 */
public enum SwitchEnum {
//    卡槽门开关
//0：关闭
//1：打开

    POEN(1),
    CLOSE(0)
    ;
    private final Integer code;

    SwitchEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
