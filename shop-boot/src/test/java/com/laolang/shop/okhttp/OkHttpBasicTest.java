package com.laolang.shop.okhttp;

import cn.hutool.json.JSONUtil;
import com.laolang.shop.modules.product.req.CategoryAddReq;
import com.laolang.shop.modules.product.req.CategoryEditReq;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class OkHttpBasicTest {

    private static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    @Test
    public void getTest() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "http://localhost:8090/product/category/list";
        Request request = new Request.Builder().url(url).method("GET", null).build();

        try (Response response = client.newCall(request).execute()) {

            Assert.assertNotNull(response.body());
            String json = response.body().string();
            log.info("request:{}", request);
            log.info("response:{}", response);
            log.info("code:{}", response.code());
            log.info("json:{}", json);
        }
    }

    @Test
    public void putTest() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "http://localhost:8090/product/category/add";
        CategoryAddReq req = new CategoryAddReq();
        req.setParentId(0L);
        req.setName("手机");
        RequestBody body = RequestBody.create(JSON, JSONUtil.toJsonStr(req));
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();

        try (Response response = client.newCall(request).execute()) {

            Assert.assertNotNull(response.body());
            String json = response.body().string();
            log.info("request:{}", request);
            log.info("response:{}", response);
            log.info("code:{}", response.code());
            log.info("json:{}", json);
        }
    }

    @Test
    public void postTest() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "http://localhost:8090/product/category/edit";
        CategoryEditReq req = new CategoryEditReq();
        req.setId(1L);
        req.setParentId(0L);
        req.setName("手机");
        RequestBody body = RequestBody.create(JSON, JSONUtil.toJsonStr(req));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {

            Assert.assertNotNull(response.body());
            String json = response.body().string();
            log.info("request:{}", request);
            log.info("response:{}", response);
            log.info("code:{}", response.code());
            log.info("json:{}", json);
        }
    }

    @Test
    public void deleteTest() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "http://localhost:8090/product/category/del/1";

        Request request = new Request.Builder().url(url).method("DELETE", null).build();

        try (Response response = client.newCall(request).execute()) {

            Assert.assertNotNull(response.body());
            String json = response.body().string();
            log.info("request:{}", request);
            log.info("response:{}", response);
            log.info("code:{}", response.code());
            log.info("json:{}", json);
        }
    }
}
