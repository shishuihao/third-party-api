package cn.shishuihao.thirdparty.api.pay.domain.merchant.contact;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class Contact {
    /**
     * 联系姓名.
     */
    private final String name;
    /**
     * 联系手机.
     */
    private final String mobile;
    /**
     * 联系邮箱.
     */
    private final String email;
}
