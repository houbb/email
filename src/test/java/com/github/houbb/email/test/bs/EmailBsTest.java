package com.github.houbb.email.test.bs;

import com.github.houbb.email.bs.EmailBs;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public class EmailBsTest {

    /**
     * 这里的用户名密码需要调整为用户自己的。
     * 记得开通 SMTP 服务
     * @since 0.0.1
     */
    @Test
    @Ignore
    public void wangYi163Test() {
        EmailBs.auth("xxx@163.com", "xxx")
                .content("自定义内容")
                .sendTo("xxx@yy.com");
    }

    /**
     * 网易 163 多个收件人测试
     * @since 0.0.2
     */
    @Test
    @Ignore
    public void wangYi163MultiReceiverTest() {
        EmailBs.auth("xxx@163.com", "xxx")
                .content("自定义主题", "自定义内容")
                .cc("抄送者1@xx.com", "抄送者2@xx.com")
                .bcc("秘密抄送者1@xx.com", "秘密抄送者2@xx.com")
                .sendTo("收件人1@xx.com", "收件人2@xx.com");
    }

}
