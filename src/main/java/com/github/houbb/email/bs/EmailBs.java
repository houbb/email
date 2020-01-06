package com.github.houbb.email.bs;

import com.github.houbb.email.core.IEmail;
import com.github.houbb.email.core.impl.WangYi163Email;
import com.github.houbb.email.support.context.SendContext;

/**
 * 邮件发送引导类
 * @author binbin.hou
 * @since 0.0.1
 */
public final class EmailBs {

    /**
     * 收件人数组
     * @since 0.0.2
     */
    private String[] toArray;

    /**
     * 抄送者数组
     * @since 0.0.2
     */
    private String[] ccArray;

    /**
     * 秘密抄送者数组
     * @since 0.0.2
     */
    private String[] bccArray;

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
        emailBs.email = new WangYi163Email(username, password);
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
     * 邮件内容
     * （1）主题默认为【无主题】，否则会被认为是垃圾邮件
     * @param content 内容
     * @return this
     * @since 0.0.2
     */
    public EmailBs content(final String content) {
        return content("无主题", content);
    }

    /**
     * 发送给收件人
     * （1）设置收件人
     * （2）直接发送邮件
     *
     * @param toArray 收件人列表
     * @return this
     * @since 0.0.1
     */
    public EmailBs sendTo(final String ... toArray) {
        this.toArray = toArray;

        // 直接开始发送
        this.send();

        return this;
    }

    /**
     * 设置抄送者
     * @param ccArray 抄送者数组
     * @return this
     * @since 0.0.2
     */
    public EmailBs cc(final String ... ccArray) {
        this.ccArray = ccArray;

        return this;
    }

    /**
     * 设置秘密抄送者
     * @param bccArray 秘密抄送者数组
     * @return this
     * @since 0.0.2
     */
    public EmailBs bcc(final String ... bccArray) {
        this.bccArray = bccArray;

        return this;
    }

    /**
     * 发送邮件
     * @since 0.0.1
     */
    private void send() {
        SendContext sendContext = buildSendContext();
        email.send(sendContext);
    }

    /**
     * 构建发送上下文
     * @return 发送上下文
     * @since 0.0.2
     */
    private SendContext buildSendContext() {
        return SendContext.newInstance()
                .subject(subject)
                .content(content)
                .toArray(toArray)
                .ccArray(ccArray)
                .bccArray(bccArray);
    }

}
