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

-   [x] [TencentSendSmsApiTest](/third-party-api-sms-tencent/src/test/java/cn/shishuihao/thirdparty/api/sms/tencent/api/TencentSendSmsApiTest.java)

### 批量发送短信(batch send sms)

-   [x] [TencentSendBatchSmsApiTest](/third-party-api-sms-tencent/src/test/java/cn/shishuihao/thirdparty/api/sms/tencent/api/TencentSendBatchSmsApiTest.java)
