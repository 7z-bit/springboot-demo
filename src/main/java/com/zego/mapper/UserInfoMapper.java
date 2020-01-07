package com.zego.mapper;

import com.zego.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> selectUserInfo(String id);
}
