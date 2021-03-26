# 微信支付sdk(weixin pay sdk)

## 官方文档

[官方文档(official document)](https://pay.weixin.qq.com/wiki/doc/api/index.html)

## 技术特点

### 纯语言开发

SDK的具体编程语言的实现，只采用纯编程语言进行开发，不引入任何重量级框架，减少潜在的框架冲突，让SDK可以自由集成进任何代码环境中。

### 结构清晰

我们按照能力类别和场景类别对API进行了归类，结构更加清晰，一目了然。<br>
更多信息请参见<a href="#API组织规范">API组织规范</a>。

### 参数精简

SDK对每个API都精心打磨，剔除了Open API中不常用的可选参数，减少普通用户的无效选择，提升开发效率。

## 安装

### Maven

```xml

<dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api-pay-weixin-sdk</artifactId>
    <version>latest</version>
</dependency>
```

### Gradle

```groovy
compile 'cn.shishuihao:third-party-api-pay-weixin-sdk:latest'
```

## API组织规范

在Alipay Easy SDK中，API的引用路径与能力地图的组织层次一致，遵循如下规范

```java
WxFactory.能力类别.场景类别.接口方法名称( ... )
```

比如，如果您想要使用能力地图中支付能力下的付款码支付场景中的付款码支付，只需按如下形式编写调用代码即可。

```java
WxFactory.Payment.codeApi().microPay( ... )
```

其中，接口方法名称通常是对其依赖的功能的一个最简概况，接口方法的出入参与官方中同名参数含义一致，可参照相关参数的使用说明。
SDK将致力于保持良好的API命名，以符合开发者的编程直觉。

## 已支持的API列表

| 能力类别             | 场景类别                      | 接口名称                 | 接口路径         | 已测试 |
| :------------------: | :---------------------------: | :----------------------: | :--------------: | :----: |
| Payment</br>支付能力 |           Common通用          |                          |                  |        |
|                      |                               | orderQuery</br>查询订单  | /pay/orderquery  | 是     |
|                      |                               | refundQuery</br>查询退款 | /pay/refundquery |        |
| Payment</br>支付能力 | WxPayCodeApi</br>付款码支付   |                          |                  |        |
|                      |                               | microPay</br>付款码支付  | /pay/micropay    | 是     |
| Payment</br>支付能力 | WxPayJsApi</br>JSAPI支付      |                          |                  |        |
| Payment</br>支付能力 | WxPayNativeApi</br>Native支付 |                          |                  |        |
| Payment</br>支付能力 | WxPayAppApi</br>App支付       |                          |                  |        |
| Payment</br>支付能力 | WxPayH5Api</br>H5支付         |                          |                  |        |
| Payment</br>支付能力 | WxPayApplet</br>Api小程序支付 |                          |                  |        |
| Payment</br>支付能力 | WxPayFaceApi</br>刷脸支付     |                          |                  |        |
