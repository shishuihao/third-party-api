package cn.shishuihao.thirdparty.api.pay.domain.merchant.contact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ContactTest {
    @Test
    void test() {
        Contact contact = Contact.builder()
                .name("姓名")
                .mobile("11111111111")
                .email("1111111111@domain.com")
                .build();
        Assertions.assertEquals("姓名", contact.getName());
    }
}