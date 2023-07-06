package com.example.myshop.api

import com.example.myshop.model.Product
import com.example.myshop.model.ProductResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/products")
    suspend fun getProducts(): Response<ProductResponse>

    @GET("/products/{id}")
     suspend fun getProducts(@Path("id")productId:Int):Response<Product>
}