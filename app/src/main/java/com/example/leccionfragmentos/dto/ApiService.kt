package com.example.leccionfragmentos.dto

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @GET("api/camiones")
    fun buscarListaProductos(): Call<List<Product>>

    @Headers("Content-Type: application/json")
    @POST("autentication/login")
    fun logearse(
        @Body usuario: User
    ): Call<String>
}