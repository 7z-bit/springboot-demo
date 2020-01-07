package com.zego.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RechargeLog implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Short type;

    private Long userId;

    private String orderId;

    private String logInfo;

    private Date createTime;
}
