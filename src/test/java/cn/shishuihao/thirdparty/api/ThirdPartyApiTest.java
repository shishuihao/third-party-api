package cn.shishuihao.thirdparty.api;

import cn.shishuihao.thirdparty.api.core.*;
import cn.shishuihao.thirdparty.api.core.impl.memory.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.core.impl.memory.ApiPropertiesMemoryRepository;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ThirdPartyApiApplication.class})
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ThirdPartyApiTest {

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