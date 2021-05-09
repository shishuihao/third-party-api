package cn.shishuihao.thirdparty.api.pay.domain.merchant.addition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AdditionTest {
    @Test
    void test() {
        Addition addition = Addition.builder()
                .legalPersonCommitment("media_id1")
                .legalPersonVideo("media_id2")
                .businessAdditionPics(new String[]{"media_id3", "media_id4", "media_id5"})
                .businessAdditionMsg("特殊情况，说明原因")
                .build();
        Assertions.assertEquals("media_id1", addition.getLegalPersonCommitment());
    }
}