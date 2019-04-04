package com.ithzk.cross.entity;

/**
 * @author hzk
 * @date 2019/4/2
 */
public class ResultData {

    private int code = 200;

    private String data;

    public ResultData(String data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
