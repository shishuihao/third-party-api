package cn.shishuihao.thirdparty.api.pay.ccb.sdk.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author admin
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public enum QrCodeType {
    /**
     * 0：未知.
     */
    UNKNOWN(0, 24, 2, 0, 62) {
        @Override
        public boolean isValid(final String qrCode) {
            for (QrCodeType value : values()) {
                if (value != this && value.isValid(qrCode)) {
                    return false;
                }
            }
            return true;
        }
    },
    /**
     * 1：龙支付.
     * 62+1位随机数+0105开头的19位纯数字串为龙支付二维码
     */
    DRAGON_PAY(19, 19, 7, 6200105, 6290105),
    /**
     * 2：微信.
     * 18位纯数字，以10、11、12、13、14、15开头）
     */
    WECHAT(18, 18, 2, 10, 15),
    /**
     * 3：支付宝.
     * 付款码将由原来的28开头扩充到25-30开头，长度由原来的16-18位扩充到16-24位。
     */
    ALIPAY(16, 24, 2, 25, 30),
    /**
     * 4：银联.
     * 银联付款码： 62开头的19位纯数字串为银联标准码。
     */
    UNION_PAY(19, 19, 2, 62, 62);
    /**
     * 最小长度.
     */
    private final int minLength;
    /**
     * 最大长度.
     */
    private final int maxLength;
    /**
     * 前缀长度.
     */
    private final int prefixLength;
    /**
     * 最小前缀.
     */
    private final int minPrefix;
    /**
     * 最大前缀.
     */
    private final int maxPrefix;

    /**
     * 获取二维码类型.
     *
     * @param qrCode 二维码
     * @return boolean
     */
    public static QrCodeType codeType(final String qrCode) {
        for (QrCodeType value : values()) {
            if (value != QrCodeType.UNKNOWN && value.isValid(qrCode)) {
                return value;
            }
        }
        return QrCodeType.UNKNOWN;
    }

    /**
     * 是否有效.
     *
     * @param qrCode 二维码
     * @return boolean
     */
    public boolean isValid(final String qrCode) {
        if (qrCode == null) {
            return false;
        }
        if (qrCode.length() < minLength || qrCode.length() > maxLength) {
            return false;
        }
        final int prefix = Integer.parseInt(StringUtils
                .substring(qrCode, 0, prefixLength));
        return prefix >= minPrefix && prefix <= maxPrefix;
    }
}
