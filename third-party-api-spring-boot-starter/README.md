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

-   [x] 配置属性配置方式
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
  
    -   [x] [yml(spring-boot-autoconfigure)](/third-party-api-spring-boot-autoconfigure/src/test/resources/application.yml)

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

-   [x] 发布事件
