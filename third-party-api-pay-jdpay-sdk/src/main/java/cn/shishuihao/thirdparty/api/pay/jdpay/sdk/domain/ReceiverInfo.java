package cn.shishuihao.thirdparty.api.pay.jdpay.sdk.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * 收货信息.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Getter
public class ReceiverInfo {
    /**
     * 收货人姓名 name String(100) 否.
     */
    private final String name;
    /**
     * 收货地址 address String(500) 否.
     */
    private final String address;
    /**
     * 收货手机号 mobile String(30) 否.
     */
    private final String mobile;
    /**
     * 收货人座机 phone String(20) 否.
     */
    private final String phone;
    /**
     * 电子邮箱 email String(100) 否.
     */
    private final String email;
    /**
     * 省份ID province String(30) 否.
     */
    private final String province;
    /**
     * 城市ID city String(30) 否.
     */
    private final String city;
    /**
     * 区县ID country String(30) 否.
     */
    private final String country;
}
