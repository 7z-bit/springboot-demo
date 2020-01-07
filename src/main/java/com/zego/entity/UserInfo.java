package com.zego.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo implements java.io.Serializable {

    /** 用户id，用户身份全�??唯一标识 */
    private Long id;

    /** 用户手机号码 同一平台手机号唯�??*/
    private String mobile;

    /** �??属平�?? 用户充�?�入口平�??*/
    private Short subordinatePlatform;

    /** 用户状�?? 是否禁用*/
    private Short state;

    /** 用户充�?�入口平台对应的用户id*/
    private String platformUserId;

    /** 代理商账�? */
    private String account;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    private String accessKey;

    private Date expiredTime;
}
