# 阿里云短信(aliyun sms)

## 官方文档

[阿里云短信(aliyun sms official document)](https://help.aliyun.com/document_detail/55288.html)

## 安装(Installation)

### Maven

```xml
<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-sms-aliyun</artifactId>
    <version>latest</version>
</dependency>
```

### Gradle

```groovy
compile 'cn.shishuihao:third-party-api-sms-aliyun:latest'
```

## 示例(example)

### 发送短信(send sms)

```java
        AliYunSmsApiProperties properties = new AliYunSmsApiProperties();
        properties.setAccessKeyId("AccessKeyId");
        properties.setAccessSecret("AccessSecret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendSmsApiResponse response = ApiRegistry.INSTANCE.execute(SendSmsApiRequest.Builder.builder()
                .channelId(AliYunSmsApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .templateId("SMS_123456789")
                .message(SmsMessage.Builder.builder()
                        .phoneNumber("8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build())
                .build());
```

### 批量发送短信(batch send sms)

```java
        AliYunSmsApiProperties properties = new AliYunSmsApiProperties();
        properties.setAccessKeyId("AccessKeyId");
        properties.setAccessSecret("AccessSecret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendBatchSmsApiResponse response = ApiRegistry.INSTANCE.execute(SendBatchSmsApiRequest.Builder.builder()
                .channelId(AliYunSmsApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .templateId("SMS_123456789")
                .messages(Arrays.asList(SmsMessage.Builder.builder()
                        .phoneNumber("8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build(), SmsMessage.Builder.builder()
                        .phoneNumber("8618511122266")
                        .signName("test")
                        .templateParams(params)
                        .build()))
                .build());
```
