package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.identity_document;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 其他国家或地区居民--护照.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class OverseaPassport extends IdentityDocument {
    /**
     * 证件类型.
     *
     * @return IdentityType
     */
    @Override
    public IdentityDocumentType getIdDocType() {
        return IdentityDocumentType.OVERSEA_PASSPORT;
    }
}
