# Email

[Email](https://github.com/houbb/email) 是基于 java 实现的发送邮件的工具包，力求简单优雅。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/email/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/email)

[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/email/blob/master/LICENSE.txt)

## 创作缘由

看了各种 email 工具感觉没有想象中方便。

就自己实现一个，后续会陆续加入新的特性。

## 特性

- Fluent 流式语法

- 网易 163 邮箱的发送支持

- 支持发送给多个收件人，多个（秘密）抄送者

## 更新记录

> [更新记录](doc/CHANGE_LOG.md)

# 快速开始

## 环境要求

jdk7+

maven 3.x+

## 引入

```xml
<plugin>
    <groupId>com.github.houbb</groupId>
    <artifactId>email</artifactId>
    <version>0.0.2</version>
</plugin>
```

## 发送邮件

此处密码为网易邮箱对应的授权码。

```java
EmailBs.auth("xxx@163.com", "xxx")
        .content("自定义内容")
        .sendTo("xxx@yy.com");
```

这里会通过 `xxx@163.com` 发送给 `xxx@yy.com` 一封邮件。

邮件标题默认为无标题，内容为你的自定义内容。

你可以通过指定，配置更多丰富的特性。

## 方法列表

| 方法 | 说明 |
|:---|:---|
| auth(username, password) | username 为邮箱名称，password 为对应密码 |
| content(subject, content) | subject 为邮件标题，content 为邮件内容 |
| content(content) | subject 默认为 "无标题"，content 为邮件内容 |
| sendTo(toArray) | toArray 为收件人列表 |
| cc(ccArray) | ccArray 为抄送人列表 |
| bcc(bccArray) | bccArray 为秘密抄送人列表 |

### 使用的例子

你可以指定多个收件人以及抄送人。

示例代码如下：

```java
EmailBs.auth("xxx@163.com", "xxx")
       .content("自定义主题", "自定义内容")
       .cc("抄送者1@xx.com", "抄送者2@xx.com")
       .bcc("秘密抄送者1@xx.com", "秘密抄送者2@xx.com")
       .sendTo("收件人1@xx.com", "收件人2@xx.com");
```

# 后续特性

- 支持常见邮箱

- 支持邮件模板