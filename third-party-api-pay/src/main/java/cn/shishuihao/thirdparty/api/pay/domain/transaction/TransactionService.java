package cn.shishuihao.thirdparty.api.pay.domain.transaction;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.pay.request.AppPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.AppletPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.H5PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.JsApiPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.NativePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.AppPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.AppletPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.H5PayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.JsApiPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.NativePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.IdWorker;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class TransactionService {
    /**
     * transaction repository .
     */
    private final TransactionRepository transactionRepository;

    /**
     * app pay.
     *
     * @param request request.
     * @return AppPayApiResponse
     */
    public AppPayApiResponse appPay(
            final AppPayApiRequest request) {
        Transaction transaction = transactionRepository
                .getByOutTradeNo(request.getOutTradeNo())
                .orElseGet(() -> newTransaction(request));
        AppPayApiResponse response = ApiRegistry.INSTANCE
                .execute(request);
        transaction.handle(response);
        transactionRepository.save(transaction);
        return response;
    }

    /**
     * applet pay.
     *
     * @param request request.
     * @return AppletPayApiResponse
     */
    public AppletPayApiResponse appletPay(
            final AppletPayApiRequest request) {
        Transaction transaction = transactionRepository
                .getByOutTradeNo(request.getOutTradeNo())
                .orElseGet(() -> newTransaction(request));
        AppletPayApiResponse response = ApiRegistry.INSTANCE
                .execute(request);
        transaction.handle(response);
        transactionRepository.save(transaction);
        return response;
    }

    /**
     * code pay.
     *
     * @param request request.
     * @return CodePayApiResponse
     */
    public CodePayApiResponse codePay(
            final CodePayApiRequest request) {
        Transaction transaction = transactionRepository
                .getByOutTradeNo(request.getOutTradeNo())
                .orElseGet(() -> newTransaction(request));
        CodePayApiResponse response = ApiRegistry.INSTANCE
                .execute(request);
        transaction.handle(response);
        transactionRepository.save(transaction);
        return response;
    }

    /**
     * h5 pay.
     *
     * @param request request.
     * @return H5PayApiResponse
     */
    public H5PayApiResponse h5Pay(
            final H5PayApiRequest request) {
        Transaction transaction = transactionRepository
                .getByOutTradeNo(request.getOutTradeNo())
                .orElseGet(() -> newTransaction(request));
        H5PayApiResponse response = ApiRegistry.INSTANCE
                .execute(request);
        transaction.handle(response);
        transactionRepository.save(transaction);
        return response;
    }

    /**
     * jsApi pay.
     *
     * @param request request.
     * @return JsApiPayApiResponse
     */
    public JsApiPayApiResponse jsApiPay(
            final JsApiPayApiRequest request) {
        Transaction transaction = transactionRepository
                .getByOutTradeNo(request.getOutTradeNo())
                .orElseGet(() -> newTransaction(request));
        JsApiPayApiResponse response = ApiRegistry.INSTANCE
                .execute(request);
        transaction.handle(response);
        transactionRepository.save(transaction);
        return response;
    }

    /**
     * native pay.
     *
     * @param request request.
     * @return NativePayApiResponse
     */
    public NativePayApiResponse nativePay(
            final NativePayApiRequest request) {
        Transaction transaction = transactionRepository
                .getByOutTradeNo(request.getOutTradeNo())
                .orElseGet(() -> newTransaction(request));
        NativePayApiResponse response = ApiRegistry.INSTANCE
                .execute(request);
        transaction.handle(response);
        transactionRepository.save(transaction);
        return response;
    }

    /**
     * query.
     *
     * @param transactionId transaction id.
     * @return QueryPayApiResponse
     */
    public QueryPayApiResponse query(final String transactionId) {
        Transaction transaction = this
                .getByTransactionId(transactionId);
        QueryPayApiResponse response = ApiRegistry.INSTANCE
                .execute(QueryPayApiRequest.builder()
                        .appId(transaction.getAppId())
                        .channelId(transaction.getChannelId())
                        .channelTransactionId(transaction
                                .getChannelTransactionId())
                        .outTradeNo(transaction.getOutTradeNo())
                        .build());
        transaction.handle(response);
        transactionRepository.save(transaction);
        return response;
    }

    /**
     * cancel.
     *
     * @param transactionId transaction id.
     * @return CancelPayApiResponse
     */
    public CancelPayApiResponse cancel(final String transactionId) {
        Transaction transaction = this
                .getByTransactionId(transactionId);
        CancelPayApiResponse response = ApiRegistry.INSTANCE
                .execute(CancelPayApiRequest.builder()
                        .appId(transaction.getAppId())
                        .channelId(transaction.getChannelId())
                        .channelTransactionId(transaction
                                .getChannelTransactionId())
                        .outTradeNo(transaction.getOutTradeNo())
                        .build());
        transaction.handle(response);
        transactionRepository.save(transaction);
        return response;
    }

    /**
     * refund.
     *
     * @param transactionId transaction id.
     * @return CancelPayApiResponse
     */
    public RefundPayApiResponse refund(final String transactionId) {
        Transaction transaction = this
                .getByTransactionId(transactionId);
        RefundPayApiResponse response = ApiRegistry.INSTANCE
                .execute(RefundPayApiRequest.builder()
                        .appId(transaction.getAppId())
                        .channelId(transaction.getChannelId())
                        .channelTransactionId(transaction
                                .getChannelTransactionId())
                        .outTradeNo(transaction.getOutTradeNo())
                        .refundAmount(transaction.getTotalAmount())
                        .build());
        transaction.handle(response);
        transactionRepository.save(transaction);
        return response;
    }

    /**
     * get transaction by transaction id.
     *
     * @param transactionId transaction id
     * @return Transaction
     */
    public Transaction getByTransactionId(
            final String transactionId) {
        return transactionRepository
                .get(transactionId)
                .orElseThrow(() -> new IllegalStateException(
                        "transaction not exist"));
    }

    private Transaction newTransaction(
            final AppPayApiRequest request) {
        Transaction newTransaction = Transaction.builder()
                .transactionId(IdWorker.nextIdString())
                .outTradeNo(request.getOutTradeNo())
                .appId(request.appId())
                .channelId(request.channelId())
                .tradeType(TradeType.APP)
                .subject(request.getSubject())
                .currency(request.getCurrency())
                .totalAmount(request.getTotalAmount())
                .tradeStatus(TradeStatus.NEW)
                .build();
        transactionRepository.save(newTransaction);
        return newTransaction;
    }

    private Transaction newTransaction(
            final AppletPayApiRequest request) {
        Transaction newTransaction = Transaction.builder()
                .transactionId(IdWorker.nextIdString())
                .outTradeNo(request.getOutTradeNo())
                .appId(request.appId())
                .channelId(request.channelId())
                .tradeType(TradeType.APPLET)
                // payerId
                .payerId(request.getPayerId())
                .subject(request.getSubject())
                .currency(request.getCurrency())
                .totalAmount(request.getTotalAmount())
                .tradeStatus(TradeStatus.NEW)
                .build();
        transactionRepository.save(newTransaction);
        return newTransaction;
    }

    private Transaction newTransaction(
            final CodePayApiRequest request) {
        Transaction newTransaction = Transaction.builder()
                .transactionId(IdWorker.nextIdString())
                .outTradeNo(request.getOutTradeNo())
                .appId(request.appId())
                .channelId(request.channelId())
                .tradeType(TradeType.CODE)
                .subject(request.getSubject())
                .currency(request.getCurrency())
                .totalAmount(request.getTotalAmount())
                // authCode
                .authCode(request.getAuthCode())
                .tradeStatus(TradeStatus.NEW)
                .build();
        transactionRepository.save(newTransaction);
        return newTransaction;
    }

    private Transaction newTransaction(
            final H5PayApiRequest request) {
        Transaction newTransaction = Transaction.builder()
                .transactionId(IdWorker.nextIdString())
                .outTradeNo(request.getOutTradeNo())
                .appId(request.appId())
                .channelId(request.channelId())
                .tradeType(TradeType.H5)
                .subject(request.getSubject())
                .currency(request.getCurrency())
                .totalAmount(request.getTotalAmount())
                .tradeStatus(TradeStatus.NEW)
                .build();
        transactionRepository.save(newTransaction);
        return newTransaction;
    }

    private Transaction newTransaction(
            final JsApiPayApiRequest request) {
        Transaction newTransaction = Transaction.builder()
                .transactionId(IdWorker.nextIdString())
                .outTradeNo(request.getOutTradeNo())
                .appId(request.appId())
                .channelId(request.channelId())
                .tradeType(TradeType.JSAPI)
                // payerId
                .payerId(request.getPayerId())
                .subject(request.getSubject())
                .currency(request.getCurrency())
                .totalAmount(request.getTotalAmount())
                .tradeStatus(TradeStatus.NEW)
                .build();
        transactionRepository.save(newTransaction);
        return newTransaction;
    }

    private Transaction newTransaction(
            final NativePayApiRequest request) {
        Transaction newTransaction = Transaction.builder()
                .transactionId(IdWorker.nextIdString())
                .outTradeNo(request.getOutTradeNo())
                .appId(request.appId())
                .channelId(request.channelId())
                .tradeType(TradeType.NATIVE)
                .subject(request.getSubject())
                .currency(request.getCurrency())
                .totalAmount(request.getTotalAmount())
                .tradeStatus(TradeStatus.NEW)
                .build();
        transactionRepository.save(newTransaction);
        return newTransaction;
    }
}
