package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.identity_document;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 中国香港居民--来往内地通行证.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class HongKongPassport extends IdentityDocument {
    /**
     * 证件类型.
     *
     * @return IdentityType
     */
    @Override
    public IdentityDocumentType getIdDocType() {
        return IdentityDocumentType.HONG_KONG_PASSPORT;
    }
}
