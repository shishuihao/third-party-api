package cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 线下场所经营场景.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class StoreSalesScenes extends SalesScenes {
    /**
     * 门店名称.
     */
    private final String storeName;
    /**
     * 门店省市编码.
     */
    private final String addressCode;
    /**
     * 门店地址.
     */
    private final String storeAddress;
    /**
     * 门店门头照片.
     */
    private final String storeEntrancePic;
    /**
     * 店内环境照片.
     */
    private final String indoorPic;
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
        return SalesScenesType.STORE;
    }
}
