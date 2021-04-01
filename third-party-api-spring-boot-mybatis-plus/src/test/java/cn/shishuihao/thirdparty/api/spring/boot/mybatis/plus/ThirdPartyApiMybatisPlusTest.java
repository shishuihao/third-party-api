package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationMemoryRepository;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.request.ApiRequest;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ThirdPartyApiMybatisPlusApplication.class})
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ThirdPartyApiMybatisPlusTest {

    @Test
    void execute() {
        TestProperties properties = new TestProperties();
        ApiConfiguration configuration = ApiConfiguration.builder()
                .appId(ApiConfiguration.class.getSimpleName())
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.add(configuration);
        Assertions.assertNotNull(ApiRegistry.INSTANCE.getApiChannelOrThrow(new CodePayRequest()));
        Assertions.assertNotNull(ApiRegistry.INSTANCE.getApiOrThrow(new CodePayRequest()));
        Assertions.assertNotNull(ApiRegistry.INSTANCE.getApiPropertiesOrThrow(new CodePayRequest()));
        CodePayResponse response = ApiRegistry.INSTANCE.execute(new CodePayRequest());
        Assertions.assertNotNull(response);
    }

    public static class TestPayChannel extends AbstractMemoryChannel<TestProperties> {
        public TestPayChannel() {
            this.add(new CodePayApi());
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

    @Getter
    @Setter
    public static class TestProperties implements ApiProperties {
        private String channelId;
        private String key = "key";
        private String value = "value";

        @Override
        public String channelId() {
            return TestPayChannel.class.getSimpleName();
        }

        @Override
        public String id() {
            return TestProperties.class.getSimpleName();
        }
    }

    static class TestApiConfigurationRepository extends ApiConfigurationMemoryRepository {
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
        public String channelId() {
            return TestPayChannel.class.getSimpleName();
        }

        @Override
        public String appId() {
            return ApiConfiguration.class.getSimpleName();
        }
    }

    static class CodePayResponse implements ApiResponse {
    }
}