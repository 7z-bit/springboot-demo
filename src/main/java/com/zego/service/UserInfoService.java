package com.zego.service;

import com.zego.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> selectUserInfo(String id);
}