package com.example.videojuegos.data.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.videojuegos.data.data.local.detail.VideojuegosDetailEntity
import com.example.videojuegos.data.data.local.list.VideojuegoEntity
import com.example.videojuegos.data.data.remote.VideojuegosAPI
import com.example.videojuegos.data.local.VideojuegosDAO

class Repository(private val videojuegosAPI: VideojuegosAPI, private val videojuegosDAO: VideojuegosDAO) {

    //Lista
    fun getSuperHeroesFromEntity(): LiveData<List<VideojuegoEntity>> =
        videojuegosDAO.getSuperHeroes()

    suspend fun getVideojuegos() {
        try {
            val response = videojuegosAPI.getDataVideojuegos() // Aqui llegan los datos
            if (response.isSuccessful) { //Evalua si llegaron los datos
                val resp = response.body() // Solo obtiene la respuesta, no tiene status
                resp?.let {
                    val VideojuegoEntity = it.map { it.transformToEntity() }
                    videojuegosDAO.insertVideojuegos(VideojuegoEntity)
                }
            }
        } catch (exception: Exception) {
            Log.e("catch", "")
        }
    }

    //Detalle
    fun getSuperHeroDetailsFromEntity(id: Int): LiveData<VideojuegosDetailEntity> =
        videojuegosDAO.getSuperHeroDetails(id)

    suspend fun getSuperHeroDetails(id: Int) {
        try {
            val response = videojuegosAPI.getSuperHeroDetails(id) // Aqui llegan los datos
            if (response.isSuccessful) { //Evalua si llegaron los datos
                val resp = response.body() // Solo obtiene la respuesta, no tiene status
                resp?.let {
                    val videojuegosDetailEntity = it.transformToDetailEntity()
                    videojuegosDAO.insertVideojuegosDetails(videojuegosDetailEntity)
                }
            }
        } catch (exception: Exception) {
            Log.e("catch", "")
        }
    }
}

