[阿里云短信(aliyun sms official document)](https://help.aliyun.com/document_detail/55288.html)

## Maven

```xml
<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-sms-aliyun</artifactId>
    <version>latest</version>
</dependency>
```

## Gradle

``` groovy
compile 'cn.shishuihao:third-party-api-sms-aliyun:latest'
```

## send sms

``` java
AliYunSmsProperties properties = new AliYunSmsProperties();
properties.setAccessKeyId("accessKeyId");
properties.setAccessSecret("accessSecret");
ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
Map<String, String> params = new TreeMap<>();
params.put("code", "12345");
SendSmsResponse response = ApiRegistry.INSTANCE.execute(SendSmsRequest.Builder.builder()
    .channelId("sms.aliyun")
    .propertiesId(properties.id())
    .phoneNumber("+8613711112222")
    .templateId("1234")
    .templateParams(params)
    .build())
    .orElse(null);
```

## send batch sms

``` java
AliYunSmsProperties properties = new AliYunSmsProperties();
properties.setAccessKeyId("accessKeyId");
properties.setAccessSecret("accessSecret");
ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
Map<String, String> params = new TreeMap<>();
params.put("code", "12345");
SendBatchSmsResponse response = ApiRegistry.INSTANCE.execute(SendBatchSmsRequest.Builder.builder()
    .channelId("sms.aliyun")
    .propertiesId(properties.id())
    .phoneNumbers(Arrays.asList("+8613711112222", "+8618511122266"))
    .templateId("1234")
    .templateParams(params)
    .build())
    .orElse(null);
```
