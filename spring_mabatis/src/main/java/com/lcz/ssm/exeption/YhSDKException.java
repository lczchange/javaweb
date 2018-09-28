package com.lcz.ssm.exeption;

import java.io.Serializable;

/**
 *
 */
public class YhSDKException extends Exception implements Serializable {

    private static final long serialVersionUID = -5844206197830354923L;

    public YhSDKException() {
    }

    public YhSDKException(String message) {
        super(message);
    }

    public YhSDKException(String message, Throwable cause) {
        super(message, cause);
    }
}
