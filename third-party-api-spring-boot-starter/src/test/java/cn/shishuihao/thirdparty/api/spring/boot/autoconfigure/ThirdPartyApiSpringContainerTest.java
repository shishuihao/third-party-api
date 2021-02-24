package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.core.*;
import cn.shishuihao.thirdparty.api.core.impl.memory.AbstractChannelMemoryImpl;
import cn.shishuihao.thirdparty.api.core.impl.memory.PropertiesRepositoryMemoryImpl;
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
class ThirdPartyApiSpringContainerTest {
    @Test
    void execute() {
        CodePayResponse response = ApiRegistry.INSTANCE.execute(new CodePayRequest());
        Assertions.assertNotNull(response);
    }

    public static class TestPayChannel extends AbstractChannelMemoryImpl {
        public TestPayChannel() {
            this.add(new CodePayApi());
        }

        @Override
        public String id() {
            return TestPayChannel.class.getSimpleName();
        }
    }

    static class TestProperties implements Properties {
        @Override
        public String id() {
            return TestProperties.class.getSimpleName();
        }
    }

    static class TestPropertiesRepository extends PropertiesRepositoryMemoryImpl {
    }

    static class CodePayApi implements Api<CodePayApi, CodePayRequest, CodePayResponse> {
        private final TestPropertiesRepository propertiesRepository = new TestPropertiesRepository();

        @Override
        public CodePayResponse execute(CodePayRequest request) throws ApiException {
            try {
                return request.responseClass().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new ApiException(e);
            }
        }

        @Override
        public Class<CodePayApi> apiType() {
            return CodePayApi.class;
        }
    }

    static class CodePayRequest implements Request<CodePayApi, CodePayRequest, CodePayResponse> {
        @Override
        public Class<CodePayResponse> responseClass() {
            return CodePayResponse.class;
        }

        @Override
        public String channelId() {
            return TestPayChannel.class.getSimpleName();
        }

        @Override
        public Class<CodePayApi> apiType() {
            return CodePayApi.class;
        }
    }

    static class CodePayResponse implements Response {
    }
}