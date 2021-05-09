package cn.shishuihao.thirdparty.api.pay.domain.common.period;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class PeriodTest {
    @Test
    void test() {
        LongTermPeriod longTermPeriod = LongTermPeriod.builder()
                .begin(LocalDate.of(2019, 8, 1))
                .build();
        Assertions.assertEquals(PeriodType.LONG_TERM, longTermPeriod.getType());
        ShortTermPeriod shortTermPeriod = ShortTermPeriod.builder()
                .begin(LocalDate.of(2019, 8, 1))
                .end(LocalDate.of(2029, 8, 1))
                .build();
        Assertions.assertEquals(PeriodType.SHORT_TERM, shortTermPeriod.getType());
    }
}