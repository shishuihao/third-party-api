package cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class BusinessInfoTest {
    @Test
    void test() {
        BusinessInfo businessInfo = BusinessInfo.builder()
                .merchantShortname("张三餐饮店")
                .servicePhone("0758XXXXX")
                .salesScenes(new LinkedHashSet<>(Arrays.asList(
                        AppSalesScenes.builder()
                                .appId("1234567890123456")
                                .pics(new String[]{"media_id1", "media_id2", "media_id3"})
                                .downloadLink(null)
                                .build(),
                        AppSalesScenes.builder()
                                .appId("1234567890123456")
                                .pics(new String[]{"media_id4", "media_id5", "media_id6"})
                                .downloadLink(null)
                                .build(),
                        StoreSalesScenes.builder()
                                .storeName("大郎烧饼")
                                .addressCode("440305")
                                .storeAddress("xx区xx大厦x层xxx室")
                                .appId("1234567890123456")
                                .storeEntrancePic("media_id1")
                                .indoorPic("media_id2")
                                .appId("1234567890123456")
                                .build(),
                        WebSalesScenes.builder()
                                .domain("https://www.domain.com")
                                .authorisation("media_id1")
                                .appId("1234567890123456")
                                .build())))
                .build();
        Assertions.assertEquals("张三餐饮店", businessInfo.getMerchantShortname());
        Assertions.assertEquals("0758XXXXX", businessInfo.getServicePhone());
        Assertions.assertEquals(3, businessInfo.getSalesScenes().size());
    }
}