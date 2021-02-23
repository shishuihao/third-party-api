# third-party-api
  第三方API集成(Third party api integration)

# 特点
  + 模块化设计
  + 高度抽象，统一接口
  + spi(Service Provider Interface)，可拔插
  + 方法使用更优雅

# 环境要求
  + JDK8+

# 功能
  + 自动发现
    + [x] spi
    + [ ] springboot
  + 配置属性获取方式
    + [x] 代码
    + [ ] yml
    + [ ] 数据库
  + [x] SMS集成(sms integration)
    + [x] [阿里云](/third-party-api-sms-aliyun/README.md)
    + [X] [腾讯云](/third-party-api-sms-tencent/README.md)
  + [x] 推送集成(push integration)
    + [X] [小米](/third-party-api-pay-xiaomi/README.md)
    + [ ] 华为
    + [ ] vivo
    + [ ] oppo
    + [ ] 魅族
    + [ ] 苹果
    + [ ] 谷歌
    + [ ] 极光推送
  + [ ] 支付集成
    + [ ] 支付宝
    + [ ] 微信
    + [ ] 银联
    + [ ] 京东
    + [ ] PayPal
    + [ ] 苹果内购
    + [ ] 工商银行
  + [ ] 登录集成
  + [ ] 分享集成



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
