package com.weibang.videohome.exception;

/**
 * @author vivo
 */
public abstract class BaseCustomException extends RuntimeException {


    BaseCustomException(String message) {
        super(message);
    }

    BaseCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
