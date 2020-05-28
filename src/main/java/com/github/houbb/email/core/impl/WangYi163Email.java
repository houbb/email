package com.github.houbb.email.core.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;

import java.util.Properties;

/**
 * 网易 163 邮箱实现
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class WangYi163Email extends AbstractEmail {

    @Override
    protected Properties buildProperties() {
        Properties props = System.getProperties();
        //1.1设置邮件发送的协议
        props.put("mail.transport.protocol", "smtp");
        //1.2设置发送邮件的服务器
        props.put("mail.smtp.host", "smtp.163.com");
        //1.3需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true");

        //1.4下面一串是发送邮件用465端口，如果不写就是以25端口发送，阿里云已经关闭了25端口
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        return props;
    }

}
