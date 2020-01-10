package com.zego.common;

import lombok.Data;

@Data
public class Result {

    private Integer code;

    private String msg;

    private Object data;
}
