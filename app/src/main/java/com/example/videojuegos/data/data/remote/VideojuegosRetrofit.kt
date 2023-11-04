package com.example.videojuegos.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VideojuegosRetrofit {
    companion object {
        private const val URL_BASE = "https://video-juegos-o6fwzuojk-mariocanedo.vercel.app/videojuegos"

        fun getSuperHeroRetrofit(): VideojuegosAPI {
            val mRetrofit = Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(
                GsonConverterFactory.create()
            ).build()
            return mRetrofit.create(VideojuegosAPI::class.java)
        }
    }
}