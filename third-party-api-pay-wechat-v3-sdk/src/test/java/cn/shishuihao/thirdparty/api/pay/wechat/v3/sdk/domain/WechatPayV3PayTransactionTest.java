package cn.shishuihao.thirdparty.api.pay.wechat.v3.sdk.domain;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WechatPayV3PayTransactionTest {

    @Test
    void fromJson() {
        String json = "{\n" +
                "\t\"transaction_id\": \"1217752501201407033233368018\",\n" +
                "\t\"amount\": {\n" +
                "\t\t\"payer_total\": 100,\n" +
                "\t\t\"total\": 100,\n" +
                "\t\t\"currency\": \"CNY\",\n" +
                "\t\t\"payer_currency\": \"CNY\"\n" +
                "\t},\n" +
                "\t\"mchid\": \"1230000109\",\n" +
                "\t\"trade_state\": \"SUCCESS\",\n" +
                "\t\"bank_type\": \"CMC\",\n" +
                "\t\"promotion_detail\": [{\n" +
                "\t\t\"amount\": 100,\n" +
                "\t\t\"wechatpay_contribute\": 0,\n" +
                "\t\t\"coupon_id\": \"109519\",\n" +
                "\t\t\"scope\": \"GLOBAL\",\n" +
                "\t\t\"merchant_contribute\": 0,\n" +
                "\t\t\"name\": \"单品惠-6\",\n" +
                "\t\t\"other_contribute\": 0,\n" +
                "\t\t\"currency\": \"CNY\",\n" +
                "\t\t\"stock_id\": \"931386\",\n" +
                "\t\t\"goods_detail\": [{\n" +
                "\t\t\t\"goods_remark\": \"商品备注信息\",\n" +
                "\t\t\t\"quantity\": 1,\n" +
                "\t\t\t\"discount_amount\": 1,\n" +
                "\t\t\t\"goods_id\": \"M1006\",\n" +
                "\t\t\t\"unit_price\": 100\n" +
                "\t\t}, {\n" +
                "\t\t\t\"goods_remark\": \"商品备注信息\",\n" +
                "\t\t\t\"quantity\": 1,\n" +
                "\t\t\t\"discount_amount\": 1,\n" +
                "\t\t\t\"goods_id\": \"M1006\",\n" +
                "\t\t\t\"unit_price\": 100\n" +
                "\t\t}]\n" +
                "\t}, {\n" +
                "\t\t\"amount\": 100,\n" +
                "\t\t\"wechatpay_contribute\": 0,\n" +
                "\t\t\"coupon_id\": \"109519\",\n" +
                "\t\t\"scope\": \"GLOBAL\",\n" +
                "\t\t\"merchant_contribute\": 0,\n" +
                "\t\t\"name\": \"单品惠-6\",\n" +
                "\t\t\"other_contribute\": 0,\n" +
                "\t\t\"currency\": \"CNY\",\n" +
                "\t\t\"stock_id\": \"931386\",\n" +
                "\t\t\"goods_detail\": [{\n" +
                "\t\t\t\"goods_remark\": \"商品备注信息\",\n" +
                "\t\t\t\"quantity\": 1,\n" +
                "\t\t\t\"discount_amount\": 1,\n" +
                "\t\t\t\"goods_id\": \"M1006\",\n" +
                "\t\t\t\"unit_price\": 100\n" +
                "\t\t}, {\n" +
                "\t\t\t\"goods_remark\": \"商品备注信息\",\n" +
                "\t\t\t\"quantity\": 1,\n" +
                "\t\t\t\"discount_amount\": 1,\n" +
                "\t\t\t\"goods_id\": \"M1006\",\n" +
                "\t\t\t\"unit_price\": 100\n" +
                "\t\t}]\n" +
                "\t}],\n" +
                "\t\"success_time\": \"2018-06-08T10:34:56+08:00\",\n" +
                "\t\"payer\": {\n" +
                "\t\t\"openid\": \"oUpF8uMuAJO_M2pxb1Q9zNjWeS6o\"\n" +
                "\t},\n" +
                "\t\"out_trade_no\": \"1217752501201407033233368018\",\n" +
                "\t\"appid\": \"wxd678efh567hg6787\",\n" +
                "\t\"trade_state_desc\": \"支付成功\",\n" +
                "\t\"trade_type\": \"MICROPAY\",\n" +
                "\t\"attach\": \"自定义数据\",\n" +
                "\t\"scene_info\": {\n" +
                "\t\t\"device_id\": \"013467007045764\"\n" +
                "\t}\n" +
                "}";
        WechatPayV3PayTransaction response = JacksonUtils.fromJson(json, WechatPayV3PayTransaction.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class).toString(),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class).toString());
    }
}