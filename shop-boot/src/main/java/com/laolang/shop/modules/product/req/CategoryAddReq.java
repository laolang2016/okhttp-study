package com.laolang.shop.modules.product.req;

import lombok.Data;

@Data
public class CategoryAddReq {

    private Long parentId;
    private String name;

}
