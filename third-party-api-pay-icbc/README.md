[工商银行官方文档(weixin official document)](https://open.icbc.com.cn/icbc/apip/api_list.html#)

## Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-pay-icbc</artifactId>
    <version>latest</version>
</dependency>
```

## Gradle

``` groovy
compile 'cn.shishuihao:third-party-api-pay-icbc:latest'
```

## code pay

``` java
        IcbcPayApiProperties properties = new IcbcPayApiProperties();
        properties.setAppId("appId");
        properties.setPrivateKey("");
        properties.setIcbcPublicKey("");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        CodePayApiRequest request = CodePayApiRequest.Builder.builder()
                .channelId(IcbcPayApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .subject("Apple iPhone11 128G")
                .outTradeNo("2234567890")
                .totalAmount(1)
                .authCode("")
                .build();
```
