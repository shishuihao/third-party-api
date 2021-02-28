package cn.shishuihao.thirdparty.api.spring.boot.mongodb;

import cn.shishuihao.thirdparty.api.core.*;
import cn.shishuihao.thirdparty.api.core.impl.memory.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.core.impl.memory.ApiPropertiesMemoryRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ThirdPartyApiMongodbApplication.class})
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ThirdPartyApiMongodbTest {
    private static final MongodStarter starter = MongodStarter.getDefaultInstance();
    private static MongodExecutable mongodExecutable;
    private static MongodProcess mongodProcess;

    @BeforeAll
    static void setUp() throws Exception {
        mongodExecutable = starter.prepare(new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(37017, Network.localhostIsIPv6()))
                .build());
        mongodProcess = mongodExecutable.start();
    }

    @AfterAll
    static void tearDown() {
        mongodProcess.stop();
        mongodExecutable.stop();
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
        private String channelId;
        private String propertiesId;
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

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getPropertiesId() {
            return propertiesId;
        }

        public void setPropertiesId(String propertiesId) {
            this.propertiesId = propertiesId;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
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