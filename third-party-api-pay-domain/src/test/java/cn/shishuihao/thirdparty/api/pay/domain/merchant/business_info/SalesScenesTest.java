package cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class SalesScenesTest {

    @Test
    void test() {
        AppSalesScenes appSalesScenes = AppSalesScenes.builder()
                .appId("1234567890123456")
                .pics(new String[]{"media_id1", "media_id2", "media_id3"})
                .downloadLink(null)
                .build();
        Assertions.assertEquals(SalesScenesType.APP, appSalesScenes.getSalesScenesType());
        StoreSalesScenes storeSalesScenes = StoreSalesScenes.builder()
                .storeName("大郎烧饼")
                .addressCode("440305")
                .storeAddress("xx区xx大厦x层xxx室")
                .appId("1234567890123456")
                .entrancePics(new String[]{"media_id1"})
                .indoorPics(new String[]{"media_id2"})
                .appId("1234567890123456")
                .build();
        Assertions.assertEquals(SalesScenesType.STORE, storeSalesScenes.getSalesScenesType());
        WebSalesScenes webSalesScenes = WebSalesScenes.builder()
                .domain("https://www.domain.com")
                .authorisation("media_id1")
                .appId("1234567890123456")
                .build();
        Assertions.assertEquals(SalesScenesType.WEB, webSalesScenes.getSalesScenesType());
    }
}