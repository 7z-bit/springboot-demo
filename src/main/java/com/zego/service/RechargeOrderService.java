package com.zego.service;

import com.zego.entity.RechargeOrder;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RechargeOrderService extends IService<RechargeOrder> {

    RechargeOrder selectByOrderNo(String orderNo);

    void updateOrder(RechargeOrder rechargeOrder);
}
