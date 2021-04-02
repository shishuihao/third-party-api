package cn.shishuihao.thirdparty.api.pay.spring.boot.controller;

import cn.shishuihao.thirdparty.api.pay.domain.transaction.Transaction;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.TransactionService;
import cn.shishuihao.thirdparty.api.pay.request.AppPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.AppletPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.H5PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.JsApiPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.NativePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.AppPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.AppletPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.H5PayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.JsApiPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.NativePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
@RequestMapping("/api/v1/pay/transactions")
@RestController
public class ThirdPartyApiPayTransactionsController {
    /**
     * transaction service.
     */
    private final TransactionService transactionService;

    /**
     * app pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/app-pay")
    public CompletableFuture<AppPayApiResponse> appPay(
            @Valid @RequestBody final AppPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                transactionService.appPay(request));
    }

    /**
     * applet pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/applet-pay")
    public CompletableFuture<AppletPayApiResponse> appletPay(
            @Valid @RequestBody final AppletPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                transactionService.appletPay(request));
    }


    /**
     * code pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/code-pay")
    public CompletableFuture<CodePayApiResponse> codePay(
            @Valid @RequestBody final CodePayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                transactionService.codePay(request));
    }

    /**
     * h5 pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/h5-pay")
    public CompletableFuture<H5PayApiResponse> h5Pay(
            @Valid @RequestBody final H5PayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                transactionService.h5Pay(request));
    }

    /**
     * js api pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/js-api-pay")
    public CompletableFuture<JsApiPayApiResponse> jsApiPay(
            @Valid @RequestBody final JsApiPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                transactionService.jsApiPay(request));
    }

    /**
     * native pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/native-pay")
    public CompletableFuture<NativePayApiResponse> jsApiPay(
            @Valid @RequestBody final NativePayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                transactionService.nativePay(request));
    }

    /**
     * get by transactionId.
     *
     * @param transactionId transaction Id
     * @return Transaction
     */
    @GetMapping("/{transactionId}")
    public Transaction get(
            @PathVariable final String transactionId) {
        return transactionService.getByTransactionId(transactionId);
    }

    /**
     * query.
     *
     * @param transactionId transaction Id
     * @return QueryPayApiResponse
     */
    @PostMapping("/{transactionId}/query")
    public QueryPayApiResponse query(
            @PathVariable final String transactionId) {
        return transactionService.query(transactionId);
    }

    /**
     * cancel.
     *
     * @param transactionId transaction Id
     * @return CancelPayApiResponse
     */
    @PostMapping("/{transactionId}/cancel")
    public CancelPayApiResponse cancel(
            @PathVariable final String transactionId) {
        return transactionService.cancel(transactionId);
    }

    /**
     * refund.
     *
     * @param transactionId transaction Id
     * @return RefundPayApiResponse
     */
    @PostMapping("/{transactionId}/refund")
    public RefundPayApiResponse refund(
            @PathVariable final String transactionId) {
        return transactionService.refund(transactionId);
    }
}
