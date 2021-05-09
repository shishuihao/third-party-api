package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.organization_info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class OrganizationInfoTest {
    @Test
    void test() {
        OrganizationInfo organizationInfo = OrganizationInfo.builder()
                .copy("media_id1")
                .code("123456789-A")
                .periodBegin(LocalDate.of(2019, 8, 1))
                .periodEnd(LocalDate.of(2029, 8, 1))
                .build();
        Assertions.assertEquals("media_id1", organizationInfo.getCopy());
    }
}