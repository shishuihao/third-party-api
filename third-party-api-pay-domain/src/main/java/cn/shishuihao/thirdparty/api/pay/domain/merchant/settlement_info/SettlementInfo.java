package cn.shishuihao.thirdparty.api.pay.domain.merchant.settlement_info;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 结算规则.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class SettlementInfo {
    /**
     * 入驻结算规则ID.
     */
    private final String settlementId;
    /**
     * 所属行业.
     */
    private final String qualificationType;
    /**
     * 特殊资质图片.
     */
    private final String[] qualifications;
}
