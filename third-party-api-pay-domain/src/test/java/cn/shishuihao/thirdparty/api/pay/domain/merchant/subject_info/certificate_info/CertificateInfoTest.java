package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.certificate_info;

import cn.shishuihao.thirdparty.api.pay.domain.common.period.ShortTermPeriod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CertificateInfoTest {
    @Test
    void test() {
        CertificateInfo certificateInfo = CertificateInfo.builder()
                .copy("media_id1")
                .type(CertificateType.CERTIFICATE_TYPE_2388)
                .number("111111111111")
                .merchantName("xx公益团体")
                .legalPerson("李四")
                .companyAddress("xx省xx市xx区xx路xx号")
                .period(ShortTermPeriod.builder()
                        .begin(LocalDate.of(2019, 8, 1))
                        .end(LocalDate.of(2029, 8, 1))
                        .build())
                .build();
        Assertions.assertEquals("media_id1", certificateInfo.getCopy());
    }
}