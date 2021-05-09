package cn.shishuihao.thirdparty.api.pay.domain.merchant.addition_info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AdditionInfoTest {
    @Test
    void test() {
        AdditionInfo additionInfo = AdditionInfo.builder()
                .legalPersonCommitment("media_id1")
                .legalPersonVideo("media_id2")
                .businessAdditionPics(new String[]{"media_id3", "media_id4", "media_id5"})
                .businessAdditionMsg("特殊情况，说明原因")
                .build();
        Assertions.assertEquals("media_id1", additionInfo.getLegalPersonCommitment());
    }
}