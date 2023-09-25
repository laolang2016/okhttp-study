package com.laolang.shop.modules.product.consts;

import com.laolang.shop.common.consts.IBizCode;

public enum ProductBizCode implements IBizCode {
    /**
     * 维护中
     */
    CATEGORY_NOT_EXIST("product-category-01", "商品分类不存在");

    /**
     * 业务状态码
     */
    private final String code;

    /**
     * 提示信息
     */
    private final String msg;

    ProductBizCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
