package com.example.videojuegos.data.remote
import com.example.videojuegos.data.remote.detail.VideojuegosDetail
import com.example.videojuegos.data.remote.list.Videojuegos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface VideojuegosAPI {

    //Lista
    @GET("videojuegos/")
    suspend fun getDataVideojuegos(): Response<List<Videojuegos>>

    //Detalle
    @GET("videojuegos/{id}")
    suspend fun getVideojuegosDetails(@Path("id") id: Int): Response<VideojuegosDetail>
}