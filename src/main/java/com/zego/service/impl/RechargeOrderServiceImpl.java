package com.zego.service.impl;

import com.zego.entity.RechargeOrder;
import com.zego.mapper.RechargeOrderMapper;
import com.zego.service.RechargeOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zego.util.GetTableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechargeOrderServiceImpl extends ServiceImpl<RechargeOrderMapper, RechargeOrder> implements RechargeOrderService {

    private final static String TABLE_NAME = "t_recharge_order";

    @Autowired
    private RechargeOrderMapper rechargeOrderMapper;

    @Override
    public RechargeOrder selectByOrderNo(String orderNo) {
        String tableName = GetTableUtil.getTable(orderNo, TABLE_NAME);
        return rechargeOrderMapper.selectByOrderNo(tableName, orderNo);
    }

    @Override
    public void updateOrder(RechargeOrder rechargeOrder) {
        String tableName = GetTableUtil.getTable(rechargeOrder.getOrderNo(), TABLE_NAME);
        rechargeOrder.setTableName(tableName);
        rechargeOrderMapper.updateOrder(rechargeOrder);
    }
}
