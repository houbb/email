package com.github.houbb.email.exception;

/**
 * 邮件运行时异常
 * @author binbin.hou
 * @since 0.0.1
 */
public class EmailRuntimeException extends RuntimeException {

    public EmailRuntimeException() {
    }

    public EmailRuntimeException(String message) {
        super(message);
    }

    public EmailRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailRuntimeException(Throwable cause) {
        super(cause);
    }

    public EmailRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
