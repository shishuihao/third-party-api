# third-party-api
第三方接口集成。如：短信、推送等等(Third party interface integration. Such as: SMS, push and so on)


# 短信接口(SMS API)

  + [腾讯云(tencent)](/third-party-api-sms-tencent/README.md)
  + [阿里云(aliyun)](/third-party-api-sms-aliyun/README.md)

# 流程(process)

```mermaid
graph LR
  A[new SendSmsRequest]-->B(ApiRegistry.INSTANCE.execute)
  B-->C(ChannelRepository.getById(SendSmsRequest.channelId()))
  C-->D(AliYunSmsChannel.getApi(SendSmsRequest.apiType()))
  D-->E(AliYunSendSmsApi.execute(SendSmsRequest))
  E-->F(AliYunClient.sendSms(new AliYunSendSmsRequest))
  G-->H(new SendSmsResponseBody)
  H-->I
```
