package cn.shishuihao.thirdparty.api.spring.boot.redis;

import cn.shishuihao.thirdparty.api.core.*;
import cn.shishuihao.thirdparty.api.core.impl.memory.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.core.impl.memory.ApiPropertiesMemoryRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import redis.embedded.RedisServer;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ThirdPartyApiRedisApplication.class})
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ThirdPartyApiRedisTest {
    private static RedisServer redisServer;

    @BeforeAll
    static void setUpRedis() {
        redisServer = RedisServer.builder()
                .port(16379)
                .setting("maxheap 200m")
                .setting("bind localhost").build();
        redisServer.start();
    }

    @AfterAll
    static void close() {
        redisServer.stop();
    }

    @Test
    void execute() {
        ApiRegistry.PROPERTIES_REPOSITORY.add(new TestProperties());
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

    static class TestApiPropertiesRepository extends ApiPropertiesMemoryRepository {
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
        public String propertiesId() {
            return TestProperties.class.getSimpleName();
        }
    }

    static class CodePayResponse implements ApiResponse {
    }
}