# 集成到springboot

## 安装

### Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-spring-boot-starter</artifactId>
    <version>latest</version>
</dependency>
```

### Gradle

``` groovy
compile 'cn.shishuihao:third-party-api-spring-boot-starter:latest'
```

## 用法 Usage

-   配置属性配置方式
    -   [x] 代码

    ```java
    @Bean
    @ConditionalOnMissingBean
    protected AliYunSmsApiProperties defaultAliYunSmsApiProperties() {
        AliYunSmsApiProperties properties = new AliYunSmsApiProperties();
        properties.setAccessKeyId("AccessKeyId");
        properties.setAccessSecret("AccessSecret");
        return properties;
    }
    ```
  
-   [x] yml（自定义）

    ```yml
    sms:
      aliyun:
        - access-key-id: AccessKeyId1
          access-secret: AccessSecret1
        - access-key-id: AccessKeyId2
          access-secret: AccessSecret2
    ```

-   [x] 数据库配置方式
    -   [x] [spring-boot-jpa](/third-party-api-spring-boot-jpa)

    ```java
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(ApiPropertiesEntityJpaRepository jpaRepository) {
        return new ApiPropertiesJpaRepository(jpaRepository);
    }
    ```

    -   [x] [spring-boot-mybatis-plus](/third-party-api-spring-boot-mybatis-plus)

    ```java
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(ApiPropertiesEntityMybatisPlusMapper mybatisPlusMapper) {
        return new ApiPropertiesMybatisPlusRepository(mybatisPlusMapper);
    }
    ```

    -   [x] [spring-boot-redis](/third-party-api-spring-boot-redis)

    ```java
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(RedisTemplate<String, ApiProperties> redisTemplate) {
        return new ApiPropertiesRedisRepository(redisTemplate);
    }
    ```

    -   [x] [spring-boot-mongodb](/third-party-api-spring-boot-mongodb)

    ```java
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(ApiPropertiesDocumentMongoRepository mongoRepository) {
        return new ApiPropertiesMongodbRepository(mongoRepository);
    }
    ```

-   发布事件
