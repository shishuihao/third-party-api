package cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * APP经营场景.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@SuperBuilder
@Data
public class AppSalesScenes extends SalesScenes {
    /**
     * 应用ID.
     */
    private final String appId;
    /**
     * 页面截图.
     */
    private final String[] pics;
    /**
     * 下载链接(选填).
     */
    private final String downloadLink;

    /**
     * 经营场景类型.
     *
     * @return SalesScenesType
     */
    @Override
    public SalesScenesType getSalesScenesType() {
        return SalesScenesType.APP;
    }
}
