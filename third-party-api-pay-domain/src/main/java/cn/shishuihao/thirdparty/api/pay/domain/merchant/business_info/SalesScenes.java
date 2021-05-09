package cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 经营场景.
 * 一种经营场景只能一项
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class SalesScenes {
    /**
     * 经营场景类型.
     */
    private final SalesScenesType salesScenesType;
}
