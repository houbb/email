package com.github.houbb.email.test.bs;

import com.github.houbb.email.bs.EmailBs;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 0.0.3
 */
@Ignore
public class EmailBsOutlookTest {

    /**
     * 这里的用户名密码需要调整为用户自己的。
     * 记得开通 SMTP 服务
     * @since 0.0.3
     */
    @Test
    public void outlookTest() {
        EmailBs.auth("xxx@outlook.com", "xxx")
                .content("自定义内容")
                .sendTo("yy@qq.com");
    }

}
