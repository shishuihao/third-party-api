package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.identity_info;

import cn.shishuihao.thirdparty.api.pay.domain.common.period.ShortTermPeriod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class IdentityInfoTest {
    @Test
    void test() {
        IdCard idCard = IdCard.builder()
                .copy("media_id1")
                .emblem("media_id2")
                .name("身份证姓名")
                .number("111111111111111111")
                .period(ShortTermPeriod.builder()
                        .begin(LocalDate.of(2026, 6, 6))
                        .end(LocalDate.of(2036, 6, 6))
                        .build())
                .build();
        Assertions.assertEquals(IdentityType.ID_CARD, idCard.getIdType());
        HongKongPassport hongKongPassport = HongKongPassport.builder()
                .copy("media_id1")
                .name("证件姓名")
                .number("111111111111111111")
                .period(ShortTermPeriod.builder()
                        .begin(LocalDate.of(2019, 6, 6))
                        .end(LocalDate.of(2036, 6, 6))
                        .build())
                .build();
        Assertions.assertEquals(IdentityType.HONG_KONG_PASSPORT, hongKongPassport.getIdType());
        MacaoPassport macaoPassport = MacaoPassport.builder()
                .copy("media_id1")
                .name("证件姓名")
                .number("111111111111111111")
                .period(ShortTermPeriod.builder()
                        .begin(LocalDate.of(2019, 6, 6))
                        .end(LocalDate.of(2036, 6, 6))
                        .build())
                .build();
        Assertions.assertEquals(IdentityType.MACAO_PASSPORT, macaoPassport.getIdType());
        OverseaPassport overseaPassport = OverseaPassport.builder()
                .copy("media_id1")
                .name("证件姓名")
                .number("111111111111111111")
                .period(ShortTermPeriod.builder()
                        .begin(LocalDate.of(2019, 6, 6))
                        .end(LocalDate.of(2036, 6, 6))
                        .build())
                .build();
        Assertions.assertEquals(IdentityType.OVERSEA_PASSPORT, overseaPassport.getIdType());
        TaiwanPassport taiwanPassport = TaiwanPassport.builder()
                .copy("media_id1")
                .name("证件姓名")
                .number("111111111111111111")
                .period(ShortTermPeriod.builder()
                        .begin(LocalDate.of(2019, 6, 6))
                        .end(LocalDate.of(2036, 6, 6))
                        .build())
                .build();
        Assertions.assertEquals(IdentityType.TAIWAN_PASSPORT, taiwanPassport.getIdType());
    }
}