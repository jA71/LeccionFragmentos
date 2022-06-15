package com.example.leccionfragmentos.dto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class WsClient {
    companion object {
       private const val URL_lista = "https://proyecto-pm.herokuapp.com/"
        private const val URL_login = "https://172.16.70.79:8080/"
       // private const val URL_lista = "https://172.16.70.79/backendRapidoMovil"
        private var retrofit: Retrofit? = null

        private fun retrofitClient(url: String): Retrofit? {
           // if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create()).build()
    //        }
            return retrofit
        }

        fun apiLogeo(): ApiService? {
            return retrofitClient(URL_login)?.create(ApiService::class.java)
        }

        fun apiLista(): ApiService? {
            return retrofitClient(URL_lista)?.create(ApiService::class.java)
        }
    }
}