[腾讯短信官方文档(tencent sms official document)](https://cloud.tencent.com/document/product/382)

## Maven

```xml
<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-sms-tencent</artifactId>
    <version>latest</version>
</dependency>
```

## Gradle

``` groovy
compile 'cn.shishuihao:third-party-api-sms-tencent:latest'
```

## send sms

``` java
        TencentSmsApiProperties properties = new TencentSmsApiProperties();
        properties.setAppId("appId");
        properties.setSecretId("secretId");
        properties.setSecretKey("secretKey");
        properties.setSign("sign");
        properties.setSenderId(null);
        properties.setExtendCode(null);
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendSmsApiResponse response = ApiRegistry.INSTANCE.execute(SendSmsApiRequest.Builder.builder()
                .channelId(TencentSmsApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .templateId("1234")
                .message(SmsMessage.Builder.builder()
                        .phoneNumber("8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build())
                .build());
        Assertions.assertNotNull(response);
```

## batch send sms

``` java
        TencentSmsApiProperties properties = new TencentSmsApiProperties();
        properties.setAppId("appId");
        properties.setSecretId("secretId");
        properties.setSecretKey("secretKey");
        properties.setSign("sign");
        properties.setSenderId(null);
        properties.setExtendCode(null);
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendBatchSmsApiResponse response = ApiRegistry.INSTANCE.execute(SendBatchSmsApiRequest.Builder.builder()
                .channelId(TencentSmsApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .templateId("1234")
                .messages(Arrays.asList(SmsMessage.Builder.builder()
                        .phoneNumber("+8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build(), SmsMessage.Builder.builder()
                        .phoneNumber("+8618511122266")
                        .signName("test")
                        .templateParams(params)
                        .build()))
                .build());
        Assertions.assertNotNull(response);
```
