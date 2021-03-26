# 小米推送(xiaomi push)

## 官方文档

[官方文档(official document)](https://dev.mi.com/console/doc/detail?pId=230)

## 安装(Installation)

### Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-push-xiaomi</artifactId>
    <version>latest</version>
</dependency>
```

### Gradle

```groovy
compile 'cn.shishuihao:third-party-api-push-xiaomi:latest'
```

## 示例(example)

### 推送消息(push message)

```java
        XiaomiPushApiProperties properties = new XiaomiPushApiProperties();
        properties.setAppId("appId");
        properties.setAppSecretKey("appSecretKey");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        PushMessageApiResponse response = ApiRegistry.INSTANCE.execute(PushMessageApiRequest.builder()
                .channelId(XiaomiPushApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build());
```
