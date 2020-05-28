package com.github.houbb.email.core.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;

import java.util.Properties;

/**
 * outlook 邮箱实现
 *
 * 配置设置：https://www.cnblogs.com/renlei-213/p/9476031.html
 * java发送outlook邮件： https://blog.csdn.net/qq_24138151/article/details/87182209
 *
 * 三：需要重新验证。
 * @author binbin.hou
 * @since 0.0.3
 */
@ThreadSafe
public class OutlookEmail extends AbstractEmail {

    @Override
    protected Properties buildProperties() {
        //获取系统属性，主要用于设置邮件相关的参数。
        Properties properties = System.getProperties();
        //设置邮件传输服务器，由于本次是发送邮件操作，所需我们需要配置smtp协议，按outlook官方同步邮件的要求，依次配置协议地址，端口号和加密方法
        properties.setProperty("mail.smtp.host", "smtp.office365.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        //用户验证并返回Session，开启用户验证，设置发送邮箱的账号密码。
        properties.setProperty("mail.smtp.auth", "true");
        return properties;
    }

}
