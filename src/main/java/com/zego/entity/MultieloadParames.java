package com.zego.entity;

import lombok.Data;

@Data
public class MultieloadParames {

    //接口地址
    private String url;

    //由Multieload提供的token
    private String token;

    //电话号码
    private String mobile;

    //充值金额
    private String amount;

    //运营商编号:1-Ooredoo 2-MPT 3-Telenor 4- Mytel 5-Mectel 6-Telenor data 7-Ooredoo data 8-MPT data
    private String opt;

    //充值订单id
    private String agentId;

    //XML/Json 返回格式，填 XML/Json
    private String fmt;

    //第n次调用
    private Integer n;
}
