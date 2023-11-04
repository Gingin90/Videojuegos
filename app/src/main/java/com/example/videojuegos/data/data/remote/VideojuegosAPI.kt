package com.example.videojuegos.data.data.remote

import com.example.videojuegos.data.data.remote.detail.SuperHeroDetail
import com.example.videojuegos.data.data.remote.list.Videojuegos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface VideojuegosAPI {

    //Lista
    @GET("superheroes/")
    suspend fun getDataSuperHero(): Response<List<Videojuegos>>

    //Detalle
    @GET("superheroes/{id}")
    suspend fun getSuperHeroDetails(@Path("id") id: Int): Response<SuperHeroDetail>
}