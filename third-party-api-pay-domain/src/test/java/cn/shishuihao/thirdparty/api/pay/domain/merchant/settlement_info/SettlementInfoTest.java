package cn.shishuihao.thirdparty.api.pay.domain.merchant.settlement_info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class SettlementInfoTest {
    @Test
    void test() {
        SettlementInfo settlementInfo = SettlementInfo.builder()
                .settlementId("719")
                .qualificationType("餐饮")
                .qualifications(new String[]{"media_id1", "media_id2", "media_id3"})
                .build();
        Assertions.assertEquals("719", settlementInfo.getSettlementId());
    }
}