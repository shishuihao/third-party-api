# 微信支付(weixin pay)

## 官方文档(official document))

[微信支付官方文档(weixin official document)](https://pay.weixin.qq.com/wiki/doc/api/index.html)

## 安装(Installation)

### Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-pay-weixin</artifactId>
    <version>latest</version>
</dependency>
```

### Gradle

```groovy
compile 'cn.shishuihao:third-party-api-pay-weixin:latest'
```

## 示例(example)

### 扫码支付(code pay)

```java
        WxPayApiProperties properties = new WxPayApiProperties();
        properties.setAppId("appId");
        properties.setKey("key");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        CodePayApiRequest request = CodePayApiRequest.builder()
                .channelId(WxPayApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .subject("Apple iPhone11 128G")
                .outTradeNo("2234567890")
                .totalAmount(1)
                .authCode("")
                .build();
```
