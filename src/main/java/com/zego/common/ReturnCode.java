package com.zego.common;

public enum ReturnCode {

    querySuccess(200, "查询成功"),
    queryFail(400, "查询失败");

    private Integer code;

    private String msg;

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    ReturnCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
