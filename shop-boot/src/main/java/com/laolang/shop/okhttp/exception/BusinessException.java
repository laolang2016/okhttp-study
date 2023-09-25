package com.laolang.shop.okhttp.exception;

import com.laolang.shop.okhttp.consts.IBizCode;
import com.laolang.shop.okhttp.consts.StandardBizCode;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String code;
    private final String msg;

    public BusinessException(String message) {
        this.code = StandardBizCode.ERROR.getCode();
        this.msg = message;
    }

    public BusinessException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(String code, String msg, String message) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(IBizCode bizCode) {
        super();
        this.code = bizCode.getCode();
        this.msg = bizCode.getMsg();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}