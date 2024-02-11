package com.example.newsapp.APIServices

import com.example.newsapp.models.news
import retrofit2.Response
import retrofit2.http.GET

interface APIinterface {

    @GET("top-headlines/category/health/in.json")
    suspend fun getNewsHealth() : Response<news>

    @GET("top-headlines/category/business/in.json")
    suspend fun getNewsBusiness() : Response<news>

    @GET("top-headlines/category/entertainment/in.json")
    suspend fun getNewsEntertainment() : Response<news>

    @GET("top-headlines/category/general/in.json")
    suspend fun getNewsGeneral() : Response<news>

    @GET("top-headlines/category/sports/in.json")
    suspend fun getNewsSports() : Response<news>

    @GET("top-headlines/category/technology/in.json")
    suspend fun getNewsTechnology() : Response<news>

    @GET("top-headlines/category/science/in.json")
    suspend fun getNewsScience() : Response<news>
}