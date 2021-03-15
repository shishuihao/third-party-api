package cn.shishuihao.thirdparty.api.push.spring.boot.web.controller;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CompletableFuture;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@RequestMapping("/api/v1/push")
public class ThirdPartyApiPushController {
    /**
     * push message.
     *
     * @param request request
     * @return response
     */
    @PostMapping
    public CompletableFuture<PushMessageApiResponse> pushMessage(
            @RequestBody final PushMessageApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }
}
