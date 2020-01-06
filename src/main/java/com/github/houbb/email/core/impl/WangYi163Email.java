package com.github.houbb.email.core.impl;

import com.github.houbb.email.core.IEmail;
import com.github.houbb.email.exception.EmailRuntimeException;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 网易 163 邮箱实现
 * @author binbin.hou
 * @since 0.0.1
 */
public class WangYi163Email implements IEmail {

    /**
     * 用户名
     * @since 0.0.1
     */
    private final String username;

    /**
     * 密码
     * @since 0.0.1
     */
    private final String password;

    private final Session session;

    public WangYi163Email(String username, String password) {
        this.username = username;
        this.password = password;
        this.session = getSession();
    }

    @Override
    public void send(String to, String subject, String content) {
        try {
            //2、创建邮件对象
            Message message = new MimeMessage(session);
            //2.1 设置发件人
            message.setFrom(new InternetAddress(username));
            //2.2 设置收件人
            message.setRecipient(RecipientType.TO, new InternetAddress(to));
            //2.3 设置抄送者（PS:没有这一条网易会认为这是一条垃圾短信，而发不出去）
            message.setRecipient(RecipientType.CC,
                    new InternetAddress(username));
            //2.4 设置邮件的主题
            message.setSubject(subject);
            //2.5 设置邮件的内容
            message.setContent("" + content + "", "text/html;charset=utf-8");

            //3、发送邮件
            Transport.send(message);
        } catch (MessagingException e) {
            throw new EmailRuntimeException(e);
        }
    }

    /**
     * 获取认证信息
     * @return 认证信息
     * @since 0.0.1
     */
    private Session getSession() {
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

        //1.5认证信息
        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

}
