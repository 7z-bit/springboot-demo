package com.zego.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zego.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> selectUserInfo(String id);

    List<UserInfo> listUser(Page<UserInfo> page);
}