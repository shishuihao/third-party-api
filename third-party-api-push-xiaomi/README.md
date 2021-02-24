[小米推送官方文档(xiaomi push official document)](https://dev.mi.com/console/doc/detail?pId=230)

## Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-push-xiaomi</artifactId>
    <version>latest</version>
</dependency>
```

## Gradle

``` groovy
compile 'cn.shishuihao:third-party-api-push-xiaomi:latest'
```

## push message

``` java
XiaomiPushProperties properties = new XiaomiPushProperties();
properties.setAppId("appId");
properties.setAppSecretKey("appSecretKey");
ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
PushMessageResponse response = ApiRegistry.INSTANCE.execute(PushMessageRequest.Builder.builder()
    .channelId("push.xiaomi")
    .propertiesId(properties.id())
    .title("title")
    .description("description")
    .payload("payload")
    .restrictedPackageName("restrictedPackageName")
    .registrationIds(new String[]{"registrationId"})
    .build());
```
