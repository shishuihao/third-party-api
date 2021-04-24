package cn.shishuihao.thirdparty.api.pay.ccb.sdk.domain;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class QrCodeTypeTest {

    @Test
    void isValid() {
        for (int i = 0; i < 10000; i++) {
            Assertions.assertTrue(QrCodeType.DRAGON_PAY.isValid("62" + RandomUtils.nextInt(0, 10) + "0105"
                    + RandomStringUtils.randomNumeric(12)));
            Assertions.assertTrue(QrCodeType.WECHAT.isValid(RandomUtils.nextInt(10, 16)
                    + RandomStringUtils.randomNumeric(16)));
            Assertions.assertTrue(QrCodeType.ALIPAY.isValid(RandomUtils.nextInt(25, 31)
                    + RandomStringUtils.randomNumeric(RandomUtils.nextInt(14, 23))));
            Assertions.assertTrue(QrCodeType.UNION_PAY.isValid("62"
                    + RandomStringUtils.randomNumeric(17)));

            Assertions.assertFalse(QrCodeType.UNKNOWN.isValid("62" + RandomUtils.nextInt(0, 10) + "0105"
                    + RandomStringUtils.randomNumeric(12)));
            Assertions.assertFalse(QrCodeType.UNKNOWN.isValid(RandomUtils.nextInt(10, 16)
                    + RandomStringUtils.randomNumeric(16)));
            Assertions.assertFalse(QrCodeType.UNKNOWN.isValid(RandomUtils.nextInt(25, 31)
                    + RandomStringUtils.randomNumeric(RandomUtils.nextInt(14, 23))));
            Assertions.assertFalse(QrCodeType.UNKNOWN.isValid("62"
                    + RandomStringUtils.randomNumeric(17)));
        }
    }
}