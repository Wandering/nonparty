package com.power.yuneng.nonparty.domain.req;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

import java.io.Serializable;


/**
 * Created by wuhun on 2017/5/17.
 */
public class BaseReq implements Serializable {

    private String url;

    protected String userid;

    protected String token;

    public BaseReq() {
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
