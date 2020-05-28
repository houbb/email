package com.github.houbb.email.core.impl;

import com.github.houbb.email.core.IEmail;
import com.github.houbb.heaven.support.instance.impl.Instances;

/**
 * <p> project: email-Emails </p>
 * <p> create on 2020/5/28 23:05 </p>
 *
 * @author binbin.hou
 * @since 0.0.3
 */
public final class Emails {

    private Emails(){}

    public static IEmail outlook() {
        return Instances.singleton(OutlookEmail.class);
    }

    public static IEmail wangYi163() {
        return Instances.singleton(WangYi163Email.class);
    }

}
