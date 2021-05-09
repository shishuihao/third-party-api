package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class BusinessLicenseInfoTest {
    @Test
    void test() {
        BusinessLicenseInfo businessLicenseInfo = BusinessLicenseInfo.builder()
                .licenseCopy("media_id1")
                .licenseNumber("123456789012345678")
                .merchantName("xx科技有限公司")
                .legalPerson("张三")
                .build();
        Assertions.assertEquals("media_id1", businessLicenseInfo.getLicenseCopy());
    }
}