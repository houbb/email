package com.github.houbb.email.bs;

import com.github.houbb.email.core.IEmail;
import com.github.houbb.email.core.impl.WangYiEmail;

/**
 * 邮件发送引导类
 * @author binbin.hou
 * @since 0.0.1
 */
public final class EmailBs {

    /**
     * 收件人
     * @since 0.0.1
     */
    private String to;

    /**
     * 主题
     * @since 0.0.1
     */
    private String subject = "";

    /**
     * 邮件内容
     * @since 0.0.1
     */
    private String content = "";

    /**
     * 邮件实现
     * @since 0.0.1
     */
    private IEmail email;

    /**
     * 登录验证
     * @param username 用户名
     * @param password 密码
     * @return this
     * @since 0.0.1
     */
    public static EmailBs auth(final String username,
                               final String password) {
        EmailBs emailBs = new EmailBs();
        emailBs.email = new WangYiEmail(username, password);
        return emailBs;
    }

    /**
     * 邮件内容
     * @param subject 主题
     * @param content 内容
     * @return this
     * @since 0.0.1
     */
    public EmailBs content(final String subject,
                           final String content) {
        this.subject = subject;
        this.content = content;
        return this;
    }

    /**
     * 发送给收件人
     * （1）设置收件人
     * （2）直接发送邮件
     *
     * @param to 收件人
     * @return this
     * @since 0.0.1
     */
    public EmailBs sendTo(final String to) {
        this.to = to;

        // 直接开始发送
        this.send();

        return this;
    }

    /**
     * 发送邮件
     * @since 0.0.1
     */
    private void send() {
        email.send(to, subject, content);
    }

}
