package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.identity_info;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 中国台湾居民--来往大陆通行证.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class TaiwanPassport extends IdentityInfo {
    /**
     * 证件类型.
     *
     * @return IdentityType
     */
    @Override
    public IdentityType getIdType() {
        return IdentityType.TAIWAN_PASSPORT;
    }
}
