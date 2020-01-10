package com.zego.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zego.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select(value = "select * from t_user_info")
    List<UserInfo> selectUserInfo(String id);

    @Select(value = "select * from t_user_info order by id desc")
    List<UserInfo> listUsers(Page<UserInfo> page);
}
