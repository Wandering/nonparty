package com.power.yuneng.nonparty.domain.res;

import java.io.Serializable;

/**
 * Created by wuhun on 2017/5/17.
 */
public class BaseRes implements Serializable{
    private int errcode;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
}
