package cn.shishuihao.thirdparty.api.spring.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SpringBootApplication
public class ThirdPartyApiJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdPartyApiJpaApplication.class, args);
    }

    @EventListener
    public void handle(ThirdPartyApiJpaTest.CodePayResponse codePayResponse) {
        System.out.println(codePayResponse);
    }
}
