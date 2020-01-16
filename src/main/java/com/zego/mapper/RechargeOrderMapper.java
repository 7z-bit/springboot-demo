package com.zego.mapper;

import com.zego.entity.RechargeOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface RechargeOrderMapper extends BaseMapper<RechargeOrder> {

    @Select(value = "select * from ${tableName} where order_no = #{orderNo}")
    RechargeOrder selectByOrderNo(String tableName, String orderNo);

    @Transactional
    @Update(value = "update ${tableName} <set><if test='orderStatus != null'>order_status = #{orderStatus}</if><if test='interfaceId != null'>interface_id = #{interfaceId}</if></set> where order_no = #{orderNo}")
    void updateOrder(RechargeOrder rechargeOrder);
}
