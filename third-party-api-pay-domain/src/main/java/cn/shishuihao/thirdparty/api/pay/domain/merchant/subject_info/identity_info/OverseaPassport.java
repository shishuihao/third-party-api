package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.identity_info;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 其他国家或地区居民--护照.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class OverseaPassport extends IdentityInfo {
    /**
     * 证件类型.
     *
     * @return IdentityType
     */
    @Override
    public IdentityType getIdType() {
        return IdentityType.OVERSEA_PASSPORT;
    }
}
