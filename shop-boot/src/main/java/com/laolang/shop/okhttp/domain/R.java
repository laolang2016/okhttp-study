package com.laolang.shop.okhttp.domain;

import com.laolang.shop.okhttp.consts.StandardBizCode;
import com.laolang.shop.okhttp.exception.BusinessException;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class R<T> {

    /**
     * 接口请求结果的业务状态吗
     */
    private String code;

    /**
     * 判断接口请求是否成功的唯一标识
     */
    private Boolean success;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据体
     */
    private T body;

    /**
     * 扩充字段,正常情况下此字段为空，当此字段有值时，意味着当前接口结构不稳定，以后会修改,即保持 extra 为空
     */
    private Object extra;

    public static <T> R<T> build(String code, boolean success, String msg, T body) {
        R<T> ajax = new R<>();
        ajax.setCode(code);
        ajax.setSuccess(success);
        ajax.setMsg(msg);
        ajax.setBody(body);
        ajax.setExtra(null);
        return ajax;
    }

    public void setPropFromBusinessException(BusinessException e) {
        setMsg(e.getMsg());
        setCode(e.getCode());
        setSuccess(false);
    }

    public static <T> R<T> ok() {
        return build(StandardBizCode.OK.getCode(), true, StandardBizCode.OK.getMsg(), null);
    }

    public static <T> R<T> ok(String code, String msg) {
        return build(code, true, msg, null);
    }

    public static <T> R<T> ok(String code, String msg, T body) {
        return build(code, true, msg, body);
    }

    public static <T> R<T> ok(T body) {
        return build(StandardBizCode.OK.getCode(), true, StandardBizCode.OK.getMsg(), body);
    }

    public static <T> R<T> failed() {
        return build(StandardBizCode.FAILED.getCode(), false, StandardBizCode.FAILED.getMsg(), null);
    }

    public static <T> R<T> failed(String msg) {
        return build(StandardBizCode.FAILED.getCode(), false, msg, null);
    }

    public static <T> R<T> doOverdue() {
        return build(StandardBizCode.OVERDUE.getCode(), false, StandardBizCode.OVERDUE.getMsg(), null);
    }

    public static <T> R<T> forbid() {
        return build(StandardBizCode.FORBID.getCode(), false, StandardBizCode.FORBID.getMsg(), null);
    }

    public static <T> R<T> error() {
        return build(StandardBizCode.ERROR.getCode(), false, StandardBizCode.ERROR.getMsg(), null);
    }

    public static <T> R<T> error(String msg) {
        return build(StandardBizCode.ERROR.getCode(), false, msg, null);
    }

    public static <T> R<T> error(String code, String msg) {
        return build(code, false, msg, null);
    }

    public static <T> R<T> doFixing() {
        return build(StandardBizCode.FIXING.getCode(), false, StandardBizCode.FIXING.getMsg(), null);
    }

    public static <T> R<T> notFount() {
        return build(StandardBizCode.NOT_FOUND.getCode(), false, StandardBizCode.NOT_FOUND.getMsg(), null);
    }

    public static <T> R<T> badRequest() {
        return build(StandardBizCode.BAD_REQUEST.getCode(), false, StandardBizCode.BAD_REQUEST.getMsg(), null);
    }

}


