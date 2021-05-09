package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class BusinessLicenseTest {
    @Test
    void test() {
        BusinessLicense businessLicense = BusinessLicense.builder()
                .copy("media_id1")
                .number("123456789012345678")
                .merchantName("xx科技有限公司")
                .legalPerson("张三")
                .build();
        Assertions.assertEquals("media_id1", businessLicense.getCopy());
    }
}