[魅族推送官方文档(xiaomi push official document)](http://open-wiki.flyme.cn/doc-wiki/index#id?129)

## Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-push-flyme</artifactId>
    <version>latest</version>
</dependency>
```

## Gradle

``` groovy
compile 'cn.shishuihao:third-party-api-push-flyme:latest'
```

## push message

``` java
        FlymePushApiProperties properties = new FlymePushApiProperties();
        properties.setAppId(0L);
        properties.setAppSecret("appSecret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        PushMessageApiResponse response = ApiRegistry.INSTANCE.execute(PushMessageApiRequest.Builder.builder()
                .channelId(FlymePushApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build());
```
