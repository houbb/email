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
                .content("Email for 2020 with bs", "新年好，我的老伙计")
                .sendTo("xxx@yy.com");
    }

}
