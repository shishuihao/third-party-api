package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.identity_info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 中国大陆居民--身份证.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class IdCard extends IdentityInfo {
    /**
     * 身份证国徽面照片.
     */
    private final String emblem;

    /**
     * 证件类型.
     *
     * @return IdentityType
     */
    @Override
    public IdentityType getIdType() {
        return IdentityType.ID_CARD;
    }
}
