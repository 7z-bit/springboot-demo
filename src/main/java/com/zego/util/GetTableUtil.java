package com.zego.util;

/**
 * All rights Reserved, Designed By www.xz_recharge.com
 * @Title:  GetTableUtil.java
 * @Package cn.com.recharge.common.util
 * @Description:    TODO(获取百库十表中的表)
 * @author: Leiming
 * @date:   2019年3月20日 上午11:23:04
 * @version V1.0
 */
public class GetTableUtil {

    /**
     * 最后两位决定订单所在数据库
     * @param str
     * @return
     */
    public static String getDatabaseName(String str) {
        String name = str.substring(str.length()-2,str.length());
        return "zego_recharge" + name;
    }

    /**
     * 倒数第三位决定订单所在表
     * @param str
     * @param tableName
     * @return
     */
    public static String getTableName(String str, String tableName) {
        String name = str.substring(str.length()-3,str.length()-2);
        return tableName + name;
    }

    /**
     *
     * @param str 订单id或者用户id后六位
     * @param tableName
     * @return
     */
    public static String getTable(String str, String tableName) {
        return getDatabaseName(str)+"."+getTableName(str, tableName.trim());
    }

}