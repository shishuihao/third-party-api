package cn.shishuihao.thirdparty.api.pay.wechat.v3.sdk.api;

import cn.shishuihao.thirdparty.api.pay.wechat.v3.sdk.WechatV3PayClient;
import cn.shishuihao.thirdparty.api.pay.wechat.v3.sdk.WechatV3Properties;
import cn.shishuihao.thirdparty.api.pay.wechat.v3.sdk.domain.WechatPayV3PayTransaction;
import feign.FeignException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WechatPayV3PayTransactionsApiTest {
    final WechatV3Properties properties = new WechatV3Properties();
    final WechatV3PayClient client = new WechatV3PayClient();

    @Test
    void getByTransactionId() {
        FeignException apiException = Assertions.assertThrows(FeignException.class, () -> {
            WechatPayV3PayTransaction transaction = client.payTransactionsApi(properties)
                    .getByTransactionId("1230000109", "1217752501201407033233368018");
            Assertions.assertEquals("1217752501201407033233368018", transaction.getTransactionId());
        });
        Assertions.assertEquals(401, apiException.status());
    }

    @Test
    void getByOutTradeNo() {
        FeignException apiException = Assertions.assertThrows(FeignException.class, () -> {
            WechatPayV3PayTransaction transaction = client.payTransactionsApi(properties)
                    .getByOutTradeNo("1230000109", "1217752501201407033233368018");
            Assertions.assertEquals("1217752501201407033233368018", transaction.getTransactionId());
        });
        Assertions.assertEquals(401, apiException.status());
    }

    @Test
    void close() {
        FeignException apiException = Assertions.assertThrows(FeignException.class, () -> {
            client.payTransactionsApi(properties)
                    .close("1230000109", "1217752501201407033233368018");
        });
        Assertions.assertEquals(401, apiException.status());
    }
}