package com.weibang.videohome.ban.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author vivo
 */
@ApiModel(value = "返回内容的数据结构")
public class MyResponseBody<T> {
    public static final int CODE_ZERO = 0;
    public static final int CODE_THREE = 3;
    public static final int CODE_ONE = 1;
    public static final int CODE_TWO = 2;
    public static final int CODE_FOUR = 4;
    public static final int CODE_FIVE = 5;

    public static final String MESSAGE_SUCCESS = "数据加载成功";
    public static final String MESSAGE_FAILED = "数据加载失败";
    public static final String MESSAGE_TOKEN_ERROR = "无效的token";


    @ApiModelProperty(value = "返回的状态码,取值有" +
            "0(正常返回)," +
            "1(错误返回:token过期)," +
            "2(错误返回:其他错误)," +
            "3(token刷新失败)," +
            "4(提示返回:带id参数返回)" +
            "5(提示返回:被标记为重复登录请求时返回(可能会带有token))",
            dataType = "String", name = "code", example = "0")
    private int code;
    @ApiModelProperty(value = "返回一个消息，简单说明返回的内容", dataType = "String", name = "message", example = "数据获取成功")
    private String message;
    @ApiModelProperty(value = "json格式的数据")
    private T data;

    private MyResponseBody() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <E> MyResponseBody<E> success(E e) {
        return success(MESSAGE_SUCCESS, e);
    }

    public static <E> MyResponseBody<E> success(String message, E e) {
        MyResponseBody<E> responseBody = new MyResponseBody<>();
        responseBody.setCode(CODE_ZERO);
        responseBody.setMessage(message);
        responseBody.setData(e);
        return responseBody;
    }

    public static MyResponseBody<String> tokenError() {
        MyResponseBody<String> responseBody = new MyResponseBody<>();
        responseBody.setCode(CODE_ONE);
        responseBody.setMessage(MESSAGE_TOKEN_ERROR);
        return responseBody;
    }

    public static <E> MyResponseBody<E> error(E e) {
        return error(MESSAGE_FAILED, e);
    }

    public static <E> MyResponseBody<E> error(String message, E e) {
        MyResponseBody<E> responseBody = new MyResponseBody<>();
        responseBody.setCode(CODE_TWO);
        responseBody.setMessage(message);
        responseBody.setData(e);
        return responseBody;
    }

    public static <E> MyResponseBody<E> error(int code, String message, E e) {
        MyResponseBody<E> responseBody = new MyResponseBody<>();
        responseBody.setCode(code);
        responseBody.setMessage(message);
        responseBody.setData(e);
        return responseBody;
    }

    public static <E> MyResponseBody<E> repeat(E e) {
        MyResponseBody<E> responseBody = new MyResponseBody<>();
        responseBody.setCode(CODE_FIVE);
        responseBody.setMessage("被标记的重复登录请求");
        responseBody.setData(e);
        return responseBody;
    }
}
