package com.github.houbb.email.core.impl;

import com.github.houbb.email.core.IEmail;
import com.github.houbb.email.exception.EmailRuntimeException;
import com.github.houbb.email.support.context.SendContext;
import com.github.houbb.email.util.AddressUtil;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 抽象邮箱实现
 *
 * 配置设置：https://www.cnblogs.com/renlei-213/p/9476031.html
 * java发送outlook邮件： https://blog.csdn.net/qq_24138151/article/details/87182209
 * @author binbin.hou
 * @since 0.0.3
 */
public abstract class AbstractEmail implements IEmail {

    @Override
    public void send(final SendContext context) {
        try {
            final String username = context.username();
            final String password = context.password();
            final Session session = getSession(username, password);

            //2、创建邮件对象
            Message message = new MimeMessage(session);
            //2.1 设置发件人
            message.setFrom(new InternetAddress(username));
            //2.2 设置收件人
            message.setRecipients(RecipientType.TO, AddressUtil.buildAddresses(context.toArray()));
            //2.3 设置抄送者（PS:没有这一条网易会认为这是一条垃圾短信，而发不出去）
            message.setRecipients(RecipientType.CC, AddressUtil.buildAddresses(context.ccArray()));
            // 设置秘密抄送者信息
            message.setRecipients(RecipientType.BCC, AddressUtil.buildAddresses(context.bccArray()));

            //2.4 设置邮件的主题
            message.setSubject(context.subject());
            //2.5 设置邮件的内容
            message.setContent(context.content(), "text/html;charset=utf-8");

            //3、发送邮件
            Transport.send(message);
        } catch (MessagingException e) {
            throw new EmailRuntimeException(e);
        }
    }

    /**
     * 获取认证信息
     * @return 认证信息
     * @since 0.0.3
     */
    protected Session getSession(final String username,
                               final String password) {
        Properties properties = buildProperties();

        //1.5认证信息
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    /**
     * 构建配置信息
     * @return 配置信息
     * @since 0.0.3
     */
    protected abstract Properties buildProperties();

}
