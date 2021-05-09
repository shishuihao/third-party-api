package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.organization_info;

import cn.shishuihao.thirdparty.api.pay.domain.common.period.ShortTermPeriod;
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
                .period(ShortTermPeriod.builder()
                        .begin(LocalDate.of(2019, 8, 1))
                        .end(LocalDate.of(2029, 8, 1))
                        .build())
                .build();
        Assertions.assertEquals("media_id1", organizationInfo.getCopy());
    }
}