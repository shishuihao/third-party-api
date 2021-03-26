# 腾讯云短信(tencent cloud sms)

## 官方文档

[官方文档(sms official document)](https://cloud.tencent.com/document/product/382)

## 安装(Installation)

### Maven

```xml
<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-sms-tencent</artifactId>
    <version>latest</version>
</dependency>
```

### Gradle

```groovy
compile 'cn.shishuihao:third-party-api-sms-tencent:latest'
```

## 示例(example)

### 发送短信(send sms)

```java
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
        SendSmsApiResponse response = ApiRegistry.INSTANCE.execute(SendSmsApiRequest.builder()
                .channelId(TencentSmsApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .templateId("1234")
                .message(SmsMessage.builder()
                        .phoneNumber("8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build())
                .build());
```

### 批量发送短信(batch send sms)

```java
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
        SendBatchSmsApiResponse response = ApiRegistry.INSTANCE.execute(SendBatchSmsApiRequest.builder()
                .channelId(TencentSmsApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .templateId("1234")
                .messages(Arrays.asList(SmsMessage.builder()
                        .phoneNumber("+8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build(), SmsMessage.builder()
                        .phoneNumber("+8618511122266")
                        .signName("test")
                        .templateParams(params)
                        .build()))
                .build());
```
