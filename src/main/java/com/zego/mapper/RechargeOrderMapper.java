package com.zego.mapper;

import com.zego.entity.RechargeOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RechargeOrderMapper extends BaseMapper<RechargeOrder> {

    RechargeOrder selectByOrderNo(String tableName, String orderNo);

    void updateOrder(RechargeOrder rechargeOrder);
}
