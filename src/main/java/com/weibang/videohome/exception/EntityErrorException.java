package com.weibang.videohome.exception;

/**
 * @author vivo
 */
public class EntityErrorException extends BaseCustomException {

    public EntityErrorException(String message) {
        super(message);
    }

    public EntityErrorException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
