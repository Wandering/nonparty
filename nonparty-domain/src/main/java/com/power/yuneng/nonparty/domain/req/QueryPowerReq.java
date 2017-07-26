package com.power.yuneng.nonparty.domain.req;

/**
 * Created by wuhun on 2017/5/17.
 */
public class QueryPowerReq extends BaseReq{

    /**
     * 查询类型，取值范围：[0：查询全部，1：名称查询，2：按ID查询，3：所属产品，4：所属设备组，5：设备MAC]，如果是按ID查询，返回设备组详细信息
     */
    private int type = 0;

    /**
     * 查询条件，如果type为0，字段不需要携带
     */
    private String search;

    /**
     * 每页显示记录数，如果不携带，表示用户下所有记录
     */
    private int listRows;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getListRows() {
        return listRows;
    }

    public void setListRows(int listRows) {
        this.listRows = listRows;
    }

    public QueryPowerReq(int listRows) {
        this.listRows = listRows;
    }

}
