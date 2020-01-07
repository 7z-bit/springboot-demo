package com.zego.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author 7z
 * @since 2020-01-07
 */
@Data
public class RechargeOrder extends Model<RechargeOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private String id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 充值单价
     */
    private Integer rechargeUnitPrice;

    /**
     * 销售单价
     */
    private Integer saleUnitPrice;

    /**
     * 运营商id
     */
    private Integer operatorId;

    /**
     * 运营商名称
     */
    private String operatorName;

    /**
     * 接口id
     */
    private Integer interfaceId;

    /**
     * 接口名称
     */
    private String interfaceName;

    /**
     * 充值数量
     */
    private Integer rechargeNum;

    /**
     * 充值总面额
     */
    private Integer rechargeMoney;

    /**
     * 付款金额
     */
    private Integer payMoney;

    /**
     * 充值电话号码
     */
    private String mobile;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 接口返回信息
     */
    private String interfaceMessage;

    /**
     * 充值回调信息
     */
    private String rechargeCallbackMessage;

    /**
     * 充值接口是否回调
     */
    private Integer isRechargeCallback;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 支付回调状态
     */
    private Integer payCallbackStatus;

    /**
     * 支付订单号
     */
    private String payOrderNo;

    /**
     * 第三方充值订单号
     */
    private String thirdRechargeOrderNo;

    /**
     * 第三方充值订单id
     */
    private String thirdRechargeOrderId;

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 平台订单id
     */
    private Long paltformOrderId;

    /**
     * 平台订单号
     */
    private String paltformOrderNo;

    /**
     * 退款状态
     */
    private Integer refundStatus;

    /**
     * 退款金额
     */
    private Integer refundMoney;

    /**
     * 订单新建时间
     */
    private LocalDateTime orderCreateTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 第三方充值时间
     */
    private LocalDateTime thirdRechargeTime;

    /**
     * 订单签名
     */
    private String shalPayMd5;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品描述
     */
    private String goodsDesc;

    /**
     * 商品类型
     */
    private Integer type;

    /**
     * 优惠券ID
     */
    private Integer couponId;

    /**
     * 优惠券码
     */
    private String couponCode;

    /**
     * 卡密
     */
    private String kammi;

    /**
     * 折扣金额
     */
    private Integer discountAmount;

    /**
     * 所属表
     */
    private String tableName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
