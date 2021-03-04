[VIVO推送官方文档(xiaomi push official document)](https://dev.vivo.com.cn/documentCenter/doc/180)

## Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-push-vivo</artifactId>
    <version>latest</version>
</dependency>
```

## Gradle

``` groovy
compile 'cn.shishuihao:third-party-api-push-vivo:latest'
```

## push message

``` java
        VivoPushApiProperties properties = new VivoPushApiProperties();
        properties.setAppKey("appKey");
        properties.setSecret("secret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        PushMessageApiRequest request = PushMessageApiRequest.Builder.builder()
                .channelId(VivoPushApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build();
```
