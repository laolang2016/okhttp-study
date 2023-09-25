package com.laolang.shop.modules.product.req;

import lombok.Data;

@Data
public class CategoryEditReq {

    private Long id;
    private Long parentId;
    private String name;

}
