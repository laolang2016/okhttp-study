package com.laolang.shop.modules.product.controller;

import cn.hutool.json.JSONUtil;
import com.laolang.shop.common.domain.R;
import com.laolang.shop.common.exception.BusinessException;
import com.laolang.shop.modules.product.consts.ProductBizCode;
import com.laolang.shop.modules.product.req.CategoryAddReq;
import com.laolang.shop.modules.product.req.CategoryEditReq;
import com.laolang.shop.modules.product.rsp.CategoryRsp;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.collections.Lists;

@Slf4j
@RequestMapping("product/category")
@RestController
public class ProductCategoryController {

    @GetMapping("list")
    public R<List<CategoryRsp>> list() {
        log.info("product/category/list");
        return R.ok(buildList());
    }

    private List<CategoryRsp> buildList() {
        List<CategoryRsp> rsps = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            CategoryRsp cate = new CategoryRsp();
            cate.setId(i + 1L);
            cate.setParentId(0L);
            cate.setName("分类-0" + i);
            rsps.add(cate);
        }
        return rsps;
    }

    @PutMapping("add")
    public R<Void> add(@RequestBody CategoryAddReq req) {
        log.info("product/category/add");
        log.info("req:{}", JSONUtil.toJsonStr(req));
        return R.ok();
    }

    @PostMapping("edit")
    public R<Void> edit(@RequestBody CategoryEditReq req) {
        log.info("product/category/edit");
        log.info("req:{}", JSONUtil.toJsonStr(req));
        if (!Objects.equals(1L, req.getId())) {
            log.error("分类信息不存在. req:{}", JSONUtil.toJsonStr(req));
            throw new BusinessException(ProductBizCode.CATEGORY_NOT_EXIST);
        }
        log.info("编辑分类信息成功");
        return R.ok();
    }

    @DeleteMapping("del/{id}")
    public R<Void> del(@PathVariable Long id){
        log.info("product/category/del");
        log.info("id:{}",id);
        if (!Objects.equals(1L, id)) {
            log.error("分类信息不存在. id:{}", id);
            throw new BusinessException(ProductBizCode.CATEGORY_NOT_EXIST);
        }
        log.info("删除分类信息成功");
        return R.ok();
    }
}
