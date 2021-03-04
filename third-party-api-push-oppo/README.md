[OPPO推送官方文档(xiaomi push official document)](https://open.oppomobile.com/wiki/doc#id=10203)

## Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-push-oppo</artifactId>
    <version>latest</version>
</dependency>
```

## Gradle

``` groovy
compile 'cn.shishuihao:third-party-api-push-oppo:latest'
```

## push message

``` java
        OppoPushApiProperties properties = new OppoPushApiProperties();
        properties.setAppKey("appKey");
        properties.setMasterSecret("masterSecret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        PushMessageApiResponse response = ApiRegistry.INSTANCE.execute(PushMessageApiRequest.Builder.builder()
                .channelId(OppoPushApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build());
```
