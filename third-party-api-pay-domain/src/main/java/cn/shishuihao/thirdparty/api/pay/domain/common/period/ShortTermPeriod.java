package cn.shishuihao.thirdparty.api.pay.domain.common.period;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * 短期有效期.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class ShortTermPeriod extends Period {
    /**
     * 有效期结束日期.
     */
    private final LocalDate end;

    /**
     * 有效期类型.
     *
     * @return PeriodType
     */
    @Override
    public PeriodType getType() {
        return PeriodType.SHORT_TERM;
    }
}
