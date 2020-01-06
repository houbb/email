package com.github.houbb.email.core;


import com.github.houbb.email.support.context.SendContext;

/**
 * 邮件接口
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IEmail {

    /**
     * 发送邮件
     * @param context 发送上下文
     * @since 0.0.1
     */
    void send(final SendContext context);

}
