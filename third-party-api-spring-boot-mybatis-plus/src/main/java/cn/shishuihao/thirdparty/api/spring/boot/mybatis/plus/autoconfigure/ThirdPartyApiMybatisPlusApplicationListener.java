package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.autoconfigure;

import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.handler.ApiPropertiesJacksonTypeHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
public class ThirdPartyApiMybatisPlusApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private final SqlSessionFactory sqlSessionFactory;

    public ThirdPartyApiMybatisPlusApplicationListener(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        TypeHandlerRegistry typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
        typeHandlerRegistry.register(ApiPropertiesJacksonTypeHandler.class.getPackage().getName());
    }
}
