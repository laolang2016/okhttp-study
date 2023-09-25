package com.laolang.shopmobile

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.junit.Test

class OkHttpBasicTest {

    private val mediaType = "application/json;charset=utf-8".toMediaTypeOrNull()

    @Test
    fun get_test() {
        val client = OkHttpClient.Builder().build()
        val url = "http://localhost:8090/product/category/list"
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        val json = response.body?.string()

        println("request: $request")
        println("response: $response")
        println("code: ${response.code}")
        println("json: $json")
    }

    @Test
    fun put_test() {
        val client = OkHttpClient.Builder().build()
        val url = "http://localhost:8090/product/category/add"
        val req = Gson().toJson(mapOf(Pair("parentId", "0"), Pair("name", "手机")))
        val body: RequestBody = req.toRequestBody(mediaType)
        val request = Request.Builder()
            .url(url)
            .put(body)
            .build()
        val response = client.newCall(request).execute()
        val json = response.body?.string()

        println("request: $request")
        println("response: $response")
        println("code: ${response.code}")
        println("json: $json")
    }

    @Test
    fun post_test() {
        val client = OkHttpClient.Builder().build()
        val url = "http://localhost:8090/product/category/edit"
        val req = Gson().toJson(mapOf(Pair("id", "1"), Pair("parentId", "0"), Pair("name", "手机")))
        val body: RequestBody = req.toRequestBody(mediaType)
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()
        val response = client.newCall(request).execute()
        val json = response.body?.string()

        println("request: $request")
        println("response: $response")
        println("code: ${response.code}")
        println("json: $json")
    }

    @Test
    fun delete_test() {
        val client = OkHttpClient.Builder().build()
        val url = "http://localhost:8090/product/category/del/1"
        val request = Request.Builder().url(url).delete(null).build()
        val response = client.newCall(request).execute()
        val json = response.body?.string()

        println("request: $request")
        println("response: $response")
        println("code: ${response.code}")
        println("json: $json")
    }

}