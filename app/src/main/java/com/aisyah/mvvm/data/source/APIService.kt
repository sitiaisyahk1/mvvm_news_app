package com.aisyah.mvvm.data.source

import com.aisyah.mvvm.data.model.ResponseNews
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=445931e514044ecebd52e610c40498cc
    @GET("top-headlines")
    suspend fun fetchNews(
        @Query("country") source: String,   //sesuai apikey
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): ResponseNews
}