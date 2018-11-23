package com.pccb.common.com.pccb.common.exception;

public class AppConfigException extends  BusinessException{


    public AppConfigException(Throwable cause) {
        super(cause);
    }

    public AppConfigException(String message) {
        super(message);
    }

    public AppConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void throwIt(String message) {
        throw new AppConfigException(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
