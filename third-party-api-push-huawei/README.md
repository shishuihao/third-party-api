# 华为推送(huawei push)

## 官方文档

[华为推送官方文档(huawei push official document)](https://developer.huawei.com/consumer/cn/hms/huawei-pushkit/)

## 安装(Installation)

### Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-push-huawei</artifactId>
    <version>latest</version>
</dependency>
```

### Gradle

```groovy
compile 'cn.shishuihao:third-party-api-push-huawei:latest'
```

## 示例(example)

### 推送消息(push message)

```java
        HuaweiPushApiProperties properties = new HuaweiPushApiProperties();
        properties.setAppId("appId");
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
