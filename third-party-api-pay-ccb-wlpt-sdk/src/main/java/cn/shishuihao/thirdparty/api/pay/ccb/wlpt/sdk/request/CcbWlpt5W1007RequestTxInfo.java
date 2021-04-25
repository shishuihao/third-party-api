package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.X （5W1007）外卡收单商户端mpi.
 * 交易名称 外卡收单商户端mpi 请求交易码 5W1007 内部交易码
 * 后端系统 ECTIP 交易类型 验证类 XML示例 Sample
 * 交易说明 商户端mpi外卡收单(安全合法验证在商户)
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W1007RequestTxInfo implements CcbWlptTxInfo {
    /**
     * 卡号长度 varChar(2) F.
     */
    @JacksonXmlProperty(localName = "CARD_LEN")
    private final String cardLength;
    /**
     * 卡号 varChar(19) F.
     */
    @JacksonXmlProperty(localName = "ACCT_NO")
    private final String acctNo;
    /**
     * 金额 varChar(14) F.
     */
    @JacksonXmlProperty(localName = "AMT1")
    private final String amt1;
    /**
     * 卡有效期 varChar(4) F.
     * 填入卡有效期YYMM
     */
    @JacksonXmlProperty(localName = "EXPIRE_DATE")
    private final String expireDate;
    /**
     * 受理行代码 varChar(11) F.
     * 接受人工电话授权的受理行
     */
    @JacksonXmlProperty(localName = "AGENT_BANK")
    private final String agentBank;
    /**
     * 商户号 varChar(15) F.
     * “集团商户”的交易，上送“子商户编号”
     */
    @JacksonXmlProperty(localName = "MERCHANT_NO")
    private final String merchantNo;
    /**
     * 柜台代码 varChar(9) F.
     */
    @JacksonXmlProperty(localName = "CUNT_NO")
    private final String counterNo;
    /**
     * 卡验证安全码 varChar(10) F.
     */
    @JacksonXmlProperty(localName = "CVV2")
    private final String cvv2;
    /**
     * 终端的流水号 varChar(6) F.
     * 前端生成的流水号(MPI返回)
     */
    @JacksonXmlProperty(localName = "TERMINAL_FLOW")
    private final String terminalFlow;
    /**
     * 交易时间 varChar(12) F.
     */
    @JacksonXmlProperty(localName = "TRADE_TIME")
    private final String tradeTime;
    /**
     * 终端号 varChar(8) F.
     * 如无，则填分行号的前8位
     */
    @JacksonXmlProperty(localName = "TERMINAL_ID")
    private final String terminalId;
    /**
     * 安全级别 varChar(2) F.
     */
    @JacksonXmlProperty(localName = "SECURE_LEV")
    private final String secureLevel;
    /**
     * 订单号 varChar(30) F.
     */
    @JacksonXmlProperty(localName = "ORDER_NO")
    private final String orderId;
    /**
     * 持卡人认证信息 varChar(40) F.
     */
    @JacksonXmlProperty(localName = "CAVV")
    private final String cavv;
    /**
     * 附加域 varChar(5) T.
     */
    @JacksonXmlProperty(localName = "EXT1")
    private final String ext1;
    /**
     * ECSLI值 varChar(3) T.
     */
    @JacksonXmlProperty(localName = "ECSLI")
    private final String ecsli;
    /**
     * 验证场景 varChar(2) F.
     */
    @JacksonXmlProperty(localName = "CHECK_RESULT")
    private final String checkResult;
}
