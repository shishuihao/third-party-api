# OPPO推送(OPPO push)

## 官方文档

[官方文档(official document)](https://open.oppomobile.com/wiki/doc#id=10203)

## 安装(Installation)

### Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-push-oppo</artifactId>
    <version>latest</version>
</dependency>
```

### Gradle

```groovy
compile 'cn.shishuihao:third-party-api-push-oppo:latest'
```

## 示例(example)

### 推送消息(push message)

```java
        OppoPushApiProperties properties = new OppoPushApiProperties();
        properties.setAppKey("appKey");
        properties.setMasterSecret("masterSecret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        PushMessageApiResponse response = ApiRegistry.INSTANCE.execute(PushMessageApiRequest.builder()
                .channelId(OppoPushApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build());
```
