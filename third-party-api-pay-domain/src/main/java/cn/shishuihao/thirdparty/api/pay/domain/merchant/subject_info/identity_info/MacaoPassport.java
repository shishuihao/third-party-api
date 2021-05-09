package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.identity_info;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 中国澳门居民--来往内地通行证.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MacaoPassport extends IdentityInfo {
    /**
     * 证件类型.
     *
     * @return IdentityType
     */
    @Override
    public IdentityType getIdType() {
        return IdentityType.MACAO_PASSPORT;
    }
}
