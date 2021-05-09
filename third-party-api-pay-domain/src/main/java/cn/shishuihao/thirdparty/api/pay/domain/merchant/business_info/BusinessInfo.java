package cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * 经营信息.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Data
public class BusinessInfo {
    /**
     * 商户简称.
     */
    private final String merchantShortname;
    /**
     * 客服电话.
     */
    private final String servicePhone;
    /**
     * 经营场景(多选，至少一项，一种一项).
     */
    private final Set<SalesScenes> salesScenes;
}
