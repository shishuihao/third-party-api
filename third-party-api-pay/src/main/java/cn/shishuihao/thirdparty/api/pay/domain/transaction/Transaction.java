package cn.shishuihao.thirdparty.api.pay.domain.transaction;

import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;
import cn.shishuihao.thirdparty.api.pay.response.AbstractPayResultApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.AppPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.AppletPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.H5PayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.JsApiPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.NativePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Getter
@Setter
public class Transaction implements AggregateRoot<String> {
    /**
     * transaction id.
     */
    private final String transactionId;
    /**
     * out trade no.
     */
    private final String outTradeNo;
    /**
     * app id.
     */
    private final String appId;
    /**
     * channel id.
     */
    private final String channelId;
    /**
     * trade type.
     */
    private final TradeType tradeType;
    /**
     * auth code.
     * such as qrcode.
     */
    private final String payerId;
    /**
     * auth code.
     * such as qrcode.
     */
    private final String authCode;
    /**
     * subject.
     */
    private final String subject;
    /**
     * currency.
     */
    private final String currency;
    /**
     * total amount.
     */
    private final int totalAmount;
    /**
     * trade status.
     */
    private TradeStatus tradeStatus;
    /**
     * channel transaction id.
     */
    private String channelTransactionId;
    /**
     * 付款银行.
     */
    private String bankType;
    /**
     * 支付币种.
     */
    private String payCurrency;
    /**
     * 支付总金额.
     */
    private Integer payTotalAmount;
    /**
     * 结算币种.
     */
    private String settleCurrency;
    /**
     * 结算总金额.
     */
    private Integer settleTotalAmount;

    /**
     * get id.
     *
     * @return id
     */
    @Override
    public String id() {
        return transactionId;
    }

    /**
     * handle AppPayApiResponse.
     *
     * @param response AppPayApiResponse
     */
    public void handle(final AppPayApiResponse response) {
        // ignore
    }

    /**
     * handle AppletPayApiResponse.
     *
     * @param response AppletPayApiResponse
     */
    public void handle(final AppletPayApiResponse response) {
        // ignore
    }

    /**
     * handle AbstractPayResultApiResponse.
     *
     * @param response AbstractPayResultApiResponse
     */
    public void handle(final AbstractPayResultApiResponse response) {
        if (response.isSuccess()) {
            Optional.ofNullable(response.getChannelTransactionId())
                    .ifPresent(this::setChannelTransactionId);
            Optional.ofNullable(response.getBankType())
                    .ifPresent(this::setBankType);
            Optional.ofNullable(response.getPayCurrency())
                    .ifPresent(this::setPayCurrency);
            Optional.ofNullable(response.getPayTotalAmount())
                    .ifPresent(this::setPayTotalAmount);
            Optional.ofNullable(response.getSettleCurrency())
                    .ifPresent(this::setSettleCurrency);
            Optional.ofNullable(response.getSettleTotalAmount())
                    .ifPresent(this::setSettleTotalAmount);
            Optional.ofNullable(response.getTradeStatus())
                    .ifPresent(this::setTradeStatus);
        }
    }

    /**
     * handle CodePayApiResponse.
     *
     * @param response CodePayApiResponse
     */
    public void handle(final CodePayApiResponse response) {
        handle((AbstractPayResultApiResponse) response);
    }

    /**
     * handle H5PayApiResponse.
     *
     * @param response H5PayApiResponse
     */
    public void handle(final H5PayApiResponse response) {
        // ignore
    }

    /**
     * handle JsApiPayApiResponse.
     *
     * @param response JsApiPayApiResponse
     */
    public void handle(final JsApiPayApiResponse response) {
        // ignore
    }

    /**
     * handle NativePayApiResponse.
     *
     * @param response NativePayApiResponse
     */
    public void handle(final NativePayApiResponse response) {
        // ignore
    }

    /**
     * handle QueryPayApiResponse.
     *
     * @param response QueryPayApiResponse
     */
    public void handle(final QueryPayApiResponse response) {
        handle((AbstractPayResultApiResponse) response);
    }

    /**
     * handle CancelPayApiResponse.
     *
     * @param response CancelPayApiResponse
     */
    public void handle(final CancelPayApiResponse response) {

    }

    /**
     * handle RefundPayApiResponse.
     *
     * @param response RefundPayApiResponse
     */
    public void handle(final RefundPayApiResponse response) {

    }
}
