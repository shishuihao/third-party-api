package cn.shishuihao.thirdparty.api.pay.domain.common.period;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * 有效期.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class Period {
    /**
     * 有效期类型.
     */
    private final PeriodType type;
    /**
     * 有效期开始日期.
     */
    private final LocalDate begin;
}
