package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.X 商户支付交易.
 * 交易名称 商户支付交易  请求交易码 520200 内部交易码
 * 后端系统 ECTIP 交易类型 支付类 XML示例 Sample
 * 交易说明 外联平台支付交易，一次往返。（报文串需要整个字符串传送，中间需无回车符，否则会签名出错）
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt520200RequestTxInfo implements CcbWlptTxInfo {
    /**
     * AUTHID 授权号 varChar(30) F.
     */
    @JacksonXmlProperty(localName = "AUTHID")
    private final String authId;
    /**
     * 定单号 varChar(30) F.
     */
    @JacksonXmlProperty(localName = "ORDERID")
    private final String orderId;
    /**
     * 一级行号 varChar(9) F.
     * 商户所属分行号
     */
    @JacksonXmlProperty(localName = "BRANCHID")
    private final String branchId;
    /**
     * 交易货币代码 varChar(2) F.
     * 交易货币代码，默认01，现在只支持01
     * 01：人民币
     */
    @JacksonXmlProperty(localName = "CURCODE")
    private final String currencyCode;
    /**
     * 交易金额 Decimal(16,2) F.
     */
    @JacksonXmlProperty(localName = "PAYMENT")
    private final String payment;
    /**
     * 网银柜台编号 varChar(9) F.
     */
    @JacksonXmlProperty(localName = "POSID")
    private final String posId;
    /**
     * 备注1 varChar(32) T.
     */
    @JacksonXmlProperty(localName = "REM1")
    private final String remark1;
    /**
     * 备注2 varChar(32) T.
     */
    @JacksonXmlProperty(localName = "REM2")
    private final String remark2;
    /**
     * 公钥前30位 varChar(30) F.
     */
    @JacksonXmlProperty(localName = "PUB32")
    private final String pub32;
    /**
     * varChar(32) T.
     * 由外联平台构造，客户只需要传空域<MAC/>.
     */
    @JacksonXmlProperty(localName = "MAC")
    private final String mac;
}
