package cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 互联网网站经营场景.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class WebSalesScenes extends SalesScenes {
    /**
     * 互联网网站域名.
     */
    private final String domain;
    /**
     * 网站授权函.
     */
    private final String authorisation;
    /**
     * 应用ID(选填).
     */
    private final String appId;

    /**
     * 经营场景类型.
     *
     * @return SalesScenesType
     */
    @Override
    public SalesScenesType getSalesScenesType() {
        return SalesScenesType.WEB;
    }
}
