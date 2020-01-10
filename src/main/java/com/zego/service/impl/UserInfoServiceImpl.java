package com.zego.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zego.entity.UserInfo;
import com.zego.mapper.UserInfoMapper;
import com.zego.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectUserInfo(String id) {

        return userInfoMapper.selectUserInfo(id);
    }

    @Override
    public List<UserInfo> listUser(Page<UserInfo> page) {
        return userInfoMapper.listUsers(page);
    }
}
