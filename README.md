<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Apache 2.0 License][license-shield]][license-url]
[![Latest Commit][latest-commit-shield]][latest-commit-url]
[![Releases][releases-shield]][releases-url]
[![REUSE status][reuse-shield]][reuse-url]
[![Build Status](https://travis-ci.com/shishuihao/third-party-api.svg?branch=main)](https://travis-ci.com/shishuihao/third-party-api)

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/shishuihao/third-party-api">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">第三方API(third-party-api)</h3>

  <p align="center">
    第三方API集成(Third party api integration)!
    <br />
    <a href="https://github.com/shishuihao/third-party-api/issues">报告Bug(Report Bug)</a>
    ·
    <a href="https://github.com/shishuihao/third-party-api/issues">请求功能(Request Feature)</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>目录(Table of Contents)</summary>
  <ol>
    <li>
      <a href="#关于该项目-about-the-project">关于该项目(About The Project)</a>
      <ul>
        <li><a href="#用什么构建-built-with">用什么构建(Built With)</a></li>
      </ul>
    </li>
    <li>
      <a href="#入门指南-getting-started">入门指南(Getting Started)</a>
      <ul>
        <li><a href="#安装-installation">安装(Installation)</a></li>
      </ul>
    </li>
    <li><a href="#用法-usage">用法(Usage)</a></li>
    <li><a href="#路线图-roadmap">路线图(Roadmap)</a></li>
    <li><a href="#贡献-contributing">贡献(Contributing)</a></li>
    <li><a href="#许可证-license">许可证(License)</a></li>
    <li><a href="#联系方式-contact">联系方式(Contact)</a></li>
    <li><a href="#致谢-acknowledgements">致谢(Acknowledgements)</a></li>
  </ol>
</details>



<!-- 关于该项目(ABOUT THE PROJECT) -->
## 关于该项目 About The Project

[![Product Name Screen Shot][product-screenshot]](https://shishuihao.github.io/third-party-api/)

GitHub上有很多很棒的第三方接口集成，但是我找不到真正适合我需要的，因此我创建了这个我认为比较优雅的实现。
我想创建一个第三方接口集成，如此出色，以至于它将成为您需要的最后一个-我想就是这样。

# 设计理念
  + 尽量领域驱动设计
  + 尽量代码规范
  + 尽量单元测试
  + 尽量使用官方sdk或者声明式HTTP(feign)
  + 尽量事件驱动

# 特点
  + 高度抽象，统一接口，模块化设计，方法使用更优雅
  + 支持多种可插拔机制，扩展性好，可按需使用
  + 支持纯java使用，也支持多种框架内使用（一般会自动配置）
  + 支持多配置参数，支持多配置参数方式
  + 支持发布事件
  + 详细可参考<a href="#用法-usage">用法(Usage)</a>

当然，由于您的需求可能不同，因此没有一个项目可以为所有项目提供服务。
因此，我将在不久的将来添加更多内容。
您也可以通过分叉此存储库并创建请求请求或打开问题来提出更改建议。
感谢所有为该项目的扩展做出贡献的人们！

致谢中列出了一些我认为有用的常用资源。

### 用什么构建 Built With

本节列出在构建项目时使用的所有主要框架。在<a href="#致谢-acknowledgements">致谢(Acknowledgements)</a>部分留下任何附加组件/插件。
* [Gradle](https://gradle.org/)
* [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)


<!-- GETTING STARTED -->
## 入门指南 Getting Started

### 安装 Installation

* Maven
  ```xml
  <dependency>
    <groupId>cn.shishuihao</groupId>
    <artifactId>third-party-api</artifactId>
    <version>latest</version>
  </dependency>
  ```
  
* Gradle
  ```grovvy
  compile 'cn.shishuihao:third-party-api:latest'
  ```



<!-- USAGE EXAMPLES -->
## 用法 Usage

  + 可插拔方式
    + [x] SPI机制
      如：[AliYunSmsApiChannel](/third-party-api-sms-aliyun/src/main/resources/META-INF/services/cn.shishuihao.thirdparty.api.core.channel.ApiChannel)的spi机制实现
      ```
      cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiChannel
      ```
    + [x] 通过注入容器，再从容器获取
      + [x] [springboot](/third-party-api-spring-boot-starter) 如注入容器
        
        ```
        @Bean
        @ConditionalOnMissingBean
        protected ApiPropertiesRepository propertiesRepository(ApiPropertiesEntityJpaRepository jpaRepository) {
            return new ApiPropertiesJpaRepository(jpaRepository);
        }
        ```
  + 配置属性配置方式
    + [x] 代码 如：
      ```
      AliYunSmsApiProperties properties = new AliYunSmsApiProperties();
      properties.setAccessKeyId("AccessKeyId");
      properties.setAccessSecret("AccessSecret");
      ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
      ```
    + [x] 容器
      + [x] [springboot](/third-party-api-spring-boot-starter)
        + [x] 代码
          ```
          @Bean
          @ConditionalOnMissingBean
          protected AliYunSmsApiProperties defaultAliYunSmsApiProperties() {
              AliYunSmsApiProperties properties = new AliYunSmsApiProperties();
              properties.setAccessKeyId("AccessKeyId");
              properties.setAccessSecret("AccessSecret");
              return properties;
          }
          ```
        + [x] yml（自定义）
          ```yml
          sms: 
            aliyun: 
              - access-key-id: AccessKeyId1
                access-secret: AccessSecret1
              - access-key-id: AccessKeyId2
                access-secret: AccessSecret2
          ```
    + [x] 数据库配置方式
      + [x] [spring-boot-jpa](/third-party-api-spring-boot-jpa)
        ```
        @Bean
        @ConditionalOnMissingBean
        protected ApiPropertiesRepository propertiesRepository(ApiPropertiesEntityJpaRepository jpaRepository) {
            return new ApiPropertiesJpaRepository(jpaRepository);
        }
        ```
      + [x] [spring-boot-mybatis-plus](/third-party-api-spring-boot-mybatis-plus)
        ```
        @Bean
        @ConditionalOnMissingBean
        protected ApiPropertiesRepository propertiesRepository(ApiPropertiesEntityMybatisPlusMapper mybatisPlusMapper) {
            return new ApiPropertiesMybatisPlusRepository(mybatisPlusMapper);
        }
        ```
      + [x] [spring-boot-redis](/third-party-api-spring-boot-redis)
        ```
        @Bean
        @ConditionalOnMissingBean
        protected ApiPropertiesRepository propertiesRepository(RedisTemplate<String, ApiProperties> redisTemplate) {
            return new ApiPropertiesRedisRepository(redisTemplate);
        }
        ```
      + [x] [spring-boot-mongodb](/third-party-api-spring-boot-mongodb)
        ```
        @Bean
        @ConditionalOnMissingBean
        protected ApiPropertiesRepository propertiesRepository(ApiPropertiesDocumentMongoRepository mongoRepository) {
            return new ApiPropertiesMongodbRepository(mongoRepository);
        }
        ```
  + 发布事件
    + [x] [springboot](/third-party-api-spring-boot-starter)
  + [x] SMS集成(sms integration)
    + [x] [阿里云](/third-party-api-sms-aliyun)
      + [X] 发送短信
      + [X] 批量发送短信
    + [X] [腾讯云](/third-party-api-sms-tencent)
      + [X] 发送短信
      + [X] 批量发送短信
  + [x] 推送集成(push integration)
    + [X] [小米(xiaomi)](/third-party-api-push-xiaomi)
      + [X] 发送消息
    + [ ] 华为(huawei)
    + [X] [VIVO](/third-party-api-push-vivo)
      + [X] 推送消息
    + [X] [OPPO](/third-party-api-push-oppo)
      + [X] 推送消息
    + [X] [魅族(flyme)](/third-party-api-push-flyme)
      + [X] 推送消息
    + [ ] 苹果(apple)
    + [ ] 谷歌(fcm)
    + [ ] 极光推送(jiguang)
  + [x] 支付集成(pay integration)
    + [x] [支付宝](/third-party-api-pay-alipay)
      + [x] 二维码支付
    + [x] [微信](/third-party-api-pay-weixin) [sdk](/third-party-api-pay-weixin-sdk)
      + [x] 二维码支付
    + [x] [工商银行](/third-party-api-pay-icbc)
      + [x] 二维码支付
    + [ ] 银联
    + [ ] 京东
    + [ ] PayPal
    + [ ] 苹果内购
  + [ ] 登录集成
  + [ ] 分享集成

* _有关更多示例，请参考[文档](https://shishuihao.github.io/third-party-api/)_
* _For more examples, please refer to the [Documentation](https://shishuihao.github.io/third-party-api/)_




<!-- ROADMAP -->
## 路线图 Roadmap

* 请参阅[未解决的问题](https://github.com/shishuihao/third-party-api/issues)，以获取提出了功能（和已知问题）的列表。
* See the [open issues](https://github.com/shishuihao/third-party-api/issues) for a list of proposed features (and known issues).



<!-- CONTRIBUTING -->
## 贡献 Contributing

1. 复刻该项目(Fork the Project)
2. 创建您的功能分支(Create your Feature Branch) (`git checkout -b feature/AmazingFeature`)
3. 提交您的更改(Commit your Changes) (`git commit -m 'Add some AmazingFeature'`)
4. 推到分支(Push to the Branch) (`git push origin feature/AmazingFeature`)
5. 提交拉取请求(Open a Pull Request)



<!-- LICENSE -->
## 许可证 License

* 根据Apache 2.0许可证分发。有关更多信息，请参见[Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)
* Distributed under the Apache 2.0 License. See [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0) for more information.



<!-- CONTACT -->
## 联系方式 Contact 

[shishuihao](https://github.com/shishuihao/) - <img width="150" src="https://avatars.githubusercontent.com/u/25605201?s=100&v=4">  - 1285173409@qq.com

下面链接(Project Link): [https://github.com/shishuihao/third-party-api](https://github.com/shishuihao/third-party-api)

<!-- ACKNOWLEDGEMENTS -->
## 致谢 Acknowledgements 
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Mybatis-Plus](https://mp.baomidou.com/)
* [Best-README-Template](https://github.com/othneildrew/Best-README-Template)



# 捐助 Donate

如果您觉得我的项目对您有帮助，并且您愿意给予我一点小小的支持，您可以通过以下方式向我捐助，这样可以维持项目持续地发展，灰常感谢！(/ω＼)

| 支付宝(Alipay) | 微信(Wechat) | 
| :------: | :------: | 
| <img width="150" src="./docs/donate/alipay.png"> | <img width="150" src="./docs/donate/wechat.jpg"> | 

❤❤❤

# 捐助者名单 Donor list

（如果这里还没有你的名字？请发邮件至 1285173409@qq.com 告诉我）

| 捐助日期 | 捐助者 | 捐助金额 |
| --- | --- | --- |

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/shishuihao/third-party-api.svg
[contributors-url]: https://github.com/shishuihao/third-party-api/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/shishuihao/third-party-api.svg
[forks-url]: https://github.com/shishuihao/third-party-api/network/members
[stars-shield]: https://img.shields.io/github/stars/shishuihao/third-party-api.svg
[stars-url]: https://github.com/shishuihao/third-party-api/stargazers
[issues-shield]: https://img.shields.io/github/issues/shishuihao/third-party-api.svg
[issues-url]: https://github.com/shishuihao/third-party-api/issues
[license-shield]: https://img.shields.io/github/license/shishuihao/third-party-api.svg
[license-url]: https://github.com/shishuihao/third-party-api/blob/master/LICENSE.txt
[latest-commit-shield]: https://img.shields.io/github/last-commit/shishuihao/third-party-api.svg
[latest-commit-url]: https://github.com/shishuihao/third-party-api/commits/main
[releases-shield]: https://img.shields.io/github/v/release/shishuihao/third-party-api.svg
[releases-url]: https://github.com/shishuihao/third-party-api/releases
[reuse-shield]: https://api.reuse.software/badge/github.com/shishuihao/third-party-api
[reuse-url]: https://api.reuse.software/info/github.com/shishuihao/third-party-api
[product-screenshot]: images/screenshot.png
