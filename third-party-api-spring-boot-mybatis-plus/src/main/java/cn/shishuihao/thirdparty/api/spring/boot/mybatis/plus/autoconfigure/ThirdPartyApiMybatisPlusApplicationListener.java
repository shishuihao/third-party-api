package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.autoconfigure;

import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.handler.ApiPropertiesJacksonTypeHandler;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
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
@ConditionalOnClass({
        SqlSessionFactory.class,
        SqlSessionFactoryBean.class
})
@AllArgsConstructor
public class ThirdPartyApiMybatisPlusApplicationListener
        implements ApplicationListener<ContextRefreshedEvent> {
    /**
     * SQL.
     */
    private static final String SQL
            = "CREATE TABLE IF NOT EXISTS api_configuration\n"
            + "(\n"
            + "    id               bigint(0)      NOT NULL AUTO_INCREMENT,\n"
            + "    gmt_create       datetime(0)    NOT NULL,\n"
            + "    gmt_modified     datetime(0)    NOT NULL,\n"
            + "    configuration_id varchar(255)   NOT NULL,\n"
            + "    app_id           varchar(255)   NOT NULL,\n"
            + "    channel_id       varchar(255)   NOT NULL,\n"
            + "    properties       varchar(10240) NULL DEFAULT NULL,\n"
            + "    PRIMARY KEY (id),\n"
            + "    UNIQUE INDEX `UK2g89p4h9vr0x67lf7ckvedtty`("
            + "app_id, channel_id)"
            + " USING BTREE\n" + ");";
    /**
     * sqlSessionFactory.
     */
    private final SqlSessionFactory sqlSessionFactory;
    /**
     * jdbcTemplate.
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(final @NonNull ContextRefreshedEvent event) {
        sqlSessionFactory.getConfiguration()
                .getTypeHandlerRegistry()
                .register(ApiPropertiesJacksonTypeHandler.class
                        .getPackage().getName());
        jdbcTemplate.execute(SQL);
    }
}
