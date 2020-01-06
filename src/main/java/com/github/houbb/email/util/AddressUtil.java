package com.github.houbb.email.util;

import com.github.houbb.email.exception.EmailRuntimeException;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * 网络地址工具类
 * @author binbin.hou
 * @since 0.0.2
 */
public final class AddressUtil {

    private AddressUtil(){}

    /**
     * 空数组
     * @since 0.0.2
     */
    private static final Address[] EMPTY_ARRAY = new Address[0];

    /**
     * 构建地址数组
     * @param addressStringArray 原始的字符串信息
     * @return 地址列表
     * @since 0.0.2
     */
    public static Address[] buildAddresses(final String[] addressStringArray) {
        if(addressStringArray == null
            || addressStringArray.length == 0) {
            return EMPTY_ARRAY;
        }

        Address[] addresses = new Address[addressStringArray.length];
        try {
            for(int i = 0; i < addressStringArray.length; i++) {
                String addressString = addressStringArray[i];
                Address address = new InternetAddress(addressString);
                addresses[i] = address;
            }
        } catch (AddressException e) {
            throw new EmailRuntimeException(e);
        }
        return addresses;
    }

}
