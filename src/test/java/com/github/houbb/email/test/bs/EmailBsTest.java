package com.github.houbb.email.test.bs;

import com.github.houbb.email.bs.EmailBs;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public class EmailBsTest {

    @Test
    public void sendToTest() {
        EmailBs.auth("xxx@163.com", "xxx")
                .content("Email for 2020 with bs", "新年好，我的老伙计")
                .sendTo("xxx@yy.com");
    }

}
