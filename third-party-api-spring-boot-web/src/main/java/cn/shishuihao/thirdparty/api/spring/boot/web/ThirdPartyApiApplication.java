package cn.shishuihao.thirdparty.api.spring.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * http api.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SpringBootApplication
public class ThirdPartyApiApplication {
    /**
     * 启动入口.
     *
     * @param args the application arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(ThirdPartyApiApplication.class, args);
    }
}
