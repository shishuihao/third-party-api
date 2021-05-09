package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.identity_document;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 中国台湾居民--来往大陆通行证.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class TaiwanPassport extends IdentityDocument {
    /**
     * 证件类型.
     *
     * @return IdentityType
     */
    @Override
    public IdentityDocumentType getIdDocType() {
        return IdentityDocumentType.TAIWAN_PASSPORT;
    }
}
