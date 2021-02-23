package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.impl.AbstractChannel;
import cn.shishuihao.thirdparty.api.core.impl.PropertiesRepositoryMemoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ApiRegistryTest {
    @Test
    void execute() {
        CodePayResponse response = ApiRegistry.INSTANCE.execute(new CodePayRequest()).orElse(null);
        Assertions.assertNotNull(response);
    }

    public static class AlipayPayChannel extends AbstractChannel {
        public AlipayPayChannel() {
            this.add(new CodePayApi());
        }

        @Override
        public String id() {
            return AlipayPayChannel.class.getSimpleName();
        }
    }

    static class AlipayProperties implements Properties {
        @Override
        public String id() {
            return AlipayProperties.class.getSimpleName();
        }
    }

    static class AlipayPropertiesRepository extends PropertiesRepositoryMemoryImpl {
    }

    static class CodePayApi implements Api<CodePayApi, CodePayRequest, CodePayResponse> {
        private final AlipayPropertiesRepository propertiesRepository = new AlipayPropertiesRepository();

        @Override
        public CodePayResponse execute(CodePayRequest request) throws ApiException {
            try {
                return request.responseClass().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new ApiException(e);
            }
        }
    }

    static class CodePayRequest implements Request<CodePayApi, CodePayRequest, CodePayResponse> {
        @Override
        public Class<CodePayResponse> responseClass() {
            return CodePayResponse.class;
        }

        @Override
        public String channelId() {
            return AlipayPayChannel.class.getSimpleName();
        }

        @Override
        public Class<CodePayApi> apiType() {
            return CodePayApi.class;
        }
    }

    static class CodePayResponse implements Response {
    }
}