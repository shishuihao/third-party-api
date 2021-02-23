[腾讯短信](https://cloud.tencent.com/document/product/382)

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
TencentSmsProperties properties = new TencentSmsProperties();
properties.setAppId("appId");
properties.setSecretId("secretId");
properties.setSecretKey("secretKey");
properties.setSign("sign");
properties.setSenderId(null);
properties.setExtendCode(null);
ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
Map<String, String> params = new TreeMap<>();
params.put("code", "12345");
SendSmsResponse response = ApiRegistry.INSTANCE.execute(SendSmsRequest.Builder.builder()
    .channelId("sms.tencent")
    .propertiesId(properties.id())
    .phoneNumber("+8613711112222")
    .templateId("1234")
    .templateParams(params)
    .build())
    .orElse(null);
```

## send batch sms

``` java
TencentSmsProperties properties = new TencentSmsProperties();
properties.setAppId("appId");
properties.setSecretId("secretId");
properties.setSecretKey("secretKey");
properties.setSign("sign");
properties.setSenderId(null);
properties.setExtendCode(null);
ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
Map<String, String> params = new TreeMap<>();
params.put("code", "12345");
SendBatchSmsResponse response = ApiRegistry.INSTANCE.execute(SendBatchSmsRequest.Builder.builder()
    .channelId("sms.tencent")
    .propertiesId(properties.id())
    .phoneNumbers(Arrays.asList("+8613711112222", "+8618511122266"))
    .templateId("1234")
    .templateParams(params)
    .build())
    .orElse(null);
```
