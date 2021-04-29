package cn.shishuihao.thirdparty.api.pay.jdpay.sdk.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * 终端信息.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Getter
public class TermInfo {
    /**
     * 终端类型 type String(50).
     * DT01:PC端，
     * DT02:移动App端，
     * DT03:移动浏览器端
     */
    private final String type;
    /**
     * 终端IP ip String(30).
     */
    private final String ip;
    /**
     * 终端MAC mac String(50).
     */
    private final String mac;
    /**
     * 终端IMEI imei String(50).
     */
    private final String imei;
    /**
     * 终端IDFV idfv String(50).
     */
    private final String idFv;
    /**
     * 终端ADID adid String(50).
     */
    private final String adId;
    /**
     * 操作系统 os String(10).
     * OS01:Android,
     * OS02:iOS,
     * OS03:Windows,
     * OS04:Mac,
     * OS05:Linux.
     */
    private final String os;
    /**
     * 操作系统版本 osVersion String(20).
     */
    private final String osVersion;
    /**
     * 终端号 termInfoId String(32).
     */
    private final String termInfoId;
}
