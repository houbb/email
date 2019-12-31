package com.github.houbb.email.core;


/**
 * 邮件接口
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IEmail {

    /**
     * 发送邮件
     * @param to 收件人
     * @param subject 主题（可以截取内容的信息）
     * @param content 内容
     * @since 0.0.1
     */
    void send(String to,
              String subject,
              String content);

}
