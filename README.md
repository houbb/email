# email

基于 java 注解生成加签验签 email。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/email/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/email)

[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/email/blob/master/LICENSE.txt)

## 创作缘由

看了各种 email 工具感觉没有想象中方便。

就自己实现一个。

## 特性

- Fluent 流式语法

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
    <version>0.0.1</version>
</plugin>
```

## 定义待加签的示例对象

```java
EmailBs.auth("xxx@163.com", "xxx")
        .content("Email for 2020 with bs", "新年好，我的老伙计")
        .sendTo("xxx@yy.com");
```