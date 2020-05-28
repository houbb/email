package com.github.houbb.email.support.context;

import java.util.Arrays;

/**
 * 发送邮件上下文
 * @author binbin.hou
 * @since 0.0.2
 */
public class SendContext {

    /**
     * 用户名
     * @since 0.0.3
     */
    private String username;

    /**
     * 密码
     * @since 0.0.3
     */
    private String password;

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
     * @since 0.0.2
     */
    private String subject;

    /**
     * 邮件内容
     * @since 0.0.2
     */
    private String content;

    public static SendContext newInstance() {
        return new SendContext();
    }

    public String[] toArray() {
        return toArray;
    }

    public SendContext toArray(String[] toArray) {
        this.toArray = toArray;
        return this;
    }

    public String[] ccArray() {
        return ccArray;
    }

    public SendContext ccArray(String[] ccArray) {
        this.ccArray = ccArray;
        return this;
    }

    public String[] bccArray() {
        return bccArray;
    }

    public SendContext bccArray(String[] bccArray) {
        this.bccArray = bccArray;
        return this;
    }

    public String subject() {
        return subject;
    }

    public SendContext subject(String subject) {
        this.subject = subject;
        return this;
    }

    public String content() {
        return content;
    }

    public SendContext content(String content) {
        this.content = content;
        return this;
    }

    public String username() {
        return username;
    }

    public SendContext username(String username) {
        this.username = username;
        return this;
    }

    public String password() {
        return password;
    }

    public SendContext password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "SendContext{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", toArray=" + Arrays.toString(toArray) +
                ", ccArray=" + Arrays.toString(ccArray) +
                ", bccArray=" + Arrays.toString(bccArray) +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
