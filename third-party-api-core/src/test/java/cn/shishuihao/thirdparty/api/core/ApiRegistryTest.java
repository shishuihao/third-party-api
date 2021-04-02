package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.request.ApiRequest;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ApiRegistryTest {

    @Test
    void execute() {
        Assertions.assertNotNull(ApiRegistry.INSTANCE.getApiChannelOrThrow(new CodePayRequest()));
        Assertions.assertNotNull(ApiRegistry.INSTANCE.getApiOrThrow(new CodePayRequest()));
        Assertions.assertNotNull(ApiRegistry.INSTANCE.getApiPropertiesOrThrow(new CodePayRequest()));
        CodePayResponse response = ApiRegistry.INSTANCE.execute(new CodePayRequest());
        Assertions.assertNotNull(response);
    }

    public static class TestPayChannel extends AbstractMemoryChannel<TestProperties> {
        public TestPayChannel() {
            this.save(new CodePayApi());
        }

        @Override
        public String id() {
            return TestPayChannel.class.getSimpleName();
        }

        @Override
        public Class<TestProperties> propertiesType() {
            return TestProperties.class;
        }
    }

    public static class TestProperties implements ApiProperties {
        @Override
        public String channelId() {
            return TestPayChannel.class.getSimpleName();
        }

        @Override
        public String id() {
            return TestProperties.class.getSimpleName();
        }
    }

    static class CodePayApi implements Api<CodePayApi, CodePayRequest, CodePayResponse> {
        @Override
        public CodePayResponse execute(CodePayRequest request) throws ApiException {
            try {
                return request.responseType().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new ApiException(e);
            }
        }

        @Override
        public Class<CodePayApi> apiType() {
            return CodePayApi.class;
        }
    }

    static class CodePayRequest implements ApiRequest<CodePayApi, CodePayRequest, CodePayResponse> {
        @Override
        public Class<CodePayApi> apiType() {
            return CodePayApi.class;
        }

        @Override
        public Class<CodePayResponse> responseType() {
            return CodePayResponse.class;
        }

        @Override
        public String appId() {
            return null;
        }

        @Override
        public String channelId() {
            return TestPayChannel.class.getSimpleName();
        }
    }

    static class CodePayResponse implements ApiResponse {
    }
}