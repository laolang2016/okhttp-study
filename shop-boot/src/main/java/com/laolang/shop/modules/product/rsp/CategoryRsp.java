package com.laolang.shop.modules.product.rsp;

import lombok.Data;

@Data
public class CategoryRsp {

    private Long id;
    private Long parentId;
    private String name;
}
