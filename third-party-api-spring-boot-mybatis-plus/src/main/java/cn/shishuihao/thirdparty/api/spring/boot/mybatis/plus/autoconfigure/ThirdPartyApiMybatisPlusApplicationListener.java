package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.autoconfigure;

import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.handler.ApiPropertiesJacksonTypeHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
public class ThirdPartyApiMybatisPlusApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final String SQL = "CREATE TABLE IF NOT EXISTS api_properties\n" +
            "(\n" +
            "    id            bigint(0)      NOT NULL AUTO_INCREMENT,\n" +
            "    gmt_create    datetime(0)    NOT NULL,\n" +
            "    gmt_modified  datetime(0)    NOT NULL,\n" +
            "    channel_id    varchar(255)   NOT NULL,\n" +
            "    properties    varchar(10240) NULL DEFAULT NULL,\n" +
            "    properties_id varchar(255)   NOT NULL,\n" +
            "    PRIMARY KEY (id),\n" +
            "    UNIQUE INDEX `UK2g89p4h9vr0x67lf7ckvedttx`(channel_id, properties_id) USING BTREE\n" +
            ");";
    private final SqlSessionFactory sqlSessionFactory;
    private final JdbcTemplate jdbcTemplate;

    public ThirdPartyApiMybatisPlusApplicationListener(SqlSessionFactory sqlSessionFactory, JdbcTemplate jdbcTemplate) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        TypeHandlerRegistry typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
        typeHandlerRegistry.register(ApiPropertiesJacksonTypeHandler.class.getPackage().getName());
        jdbcTemplate.execute(SQL);
    }
}
