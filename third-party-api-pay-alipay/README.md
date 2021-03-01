[支付宝官方文档(alipay official document)](https://openhome.alipay.com/docCenter/docCenter.htm?from=openhomemenu)

## Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-pay-alipay</artifactId>
    <version>latest</version>
</dependency>
```

## Gradle

``` groovy
compile 'cn.shishuihao:third-party-api-pay-alipay:latest'
```

## code pay

``` java
        AlipayPayApiProperties properties = new AlipayPayApiProperties();
        properties.setAppId("appId");
        properties.setMerchantPrivateKey("");
        properties.setAlipayPublicKey("");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        CodePayApiRequest request = CodePayApiRequest.Builder.builder()
                .channelId(AlipayPayApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .subject("Apple iPhone11 128G")
                .outTradeNo("2234567890")
                .totalAmount(1)
                .authCode("")
                .build();
```
