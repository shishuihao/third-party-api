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
    + [x] springboot
  + 配置属性获取方式
    + [x] 代码
    + [ ] yml
    + [ ] 数据库
  + [x] SMS集成(sms integration)
    + [x] [阿里云](/third-party-api-sms-aliyun/README.md)
      + [X] 发送短信
      + [X] 批量发送短信
    + [X] [腾讯云](/third-party-api-sms-tencent/README.md)
      + [X] 发送短信
      + [X] 批量发送短信
  + [x] 推送集成(push integration)
    + [X] [小米](/third-party-api-push-xiaomi/README.md)
      + [X] 发送消息
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



# 流程示例(process example)
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

# 捐助作者

如果您觉得我的项目对您有帮助，并且您愿意给予我一点小小的支持，您可以通过以下方式向我捐助，这样可以维持项目持续地发展，灰常感谢！(/ω＼)

| Alipay | Wechat | 
| :------: | :------: | 
| <img width="150" src="./docs/donate/alipay.png"> | <img width="150" src="./docs/donate/wechat.jpg"> | 

❤❤❤

### 捐助者名单

（如果这里还没有你的名字？请发邮件至 1285173409@qq.com 告诉我）

| 捐助日期 | 捐助者 | 捐助金额 |
| --- | --- | --- |

