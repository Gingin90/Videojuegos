package com.example.videojuegos.data.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.videojuegos.data.data.local.VideojuegosDAO
import com.example.superheroescomics.data.local.detail.SuperHeroDetailEntity
import com.example.videojuegos.data.data.local.list.VideojuegoEntity
import com.example.videojuegos.data.data.remote.VideojuegosAPI

class Repository(private val videojuegosAPI: VideojuegosAPI, private val videojuegosDAO: VideojuegosDAO) {

    //Lista
    fun getSuperHeroesFromEntity(): LiveData<List<VideojuegoEntity>> =
        videojuegosDAO.getSuperHeroes()

    suspend fun getSuperHeroes() {
        try {
            val response = videojuegosAPI.getDataSuperHero() // Aqui llegan los datos
            if (response.isSuccessful) { //Evalua si llegaron los datos
                val resp = response.body() // Solo obtiene la respuesta, no tiene status
                resp?.let {
                    val superHeroEntity = it.map { it.transformToEntity() }
                    videojuegosDAO.insertSuperHeroes(superHeroEntity)
                }
            }
        } catch (exception: Exception) {
            Log.e("catch", "")
        }
    }

    //Detalle
    fun getSuperHeroDetailsFromEntity(id: Int): LiveData<SuperHeroDetailEntity> =
        videojuegosDAO.getSuperHeroDetails(id)

    suspend fun getSuperHeroDetails(id: Int) {
        try {
            val response = videojuegosAPI.getSuperHeroDetails(id) // Aqui llegan los datos
            if (response.isSuccessful) { //Evalua si llegaron los datos
                val resp = response.body() // Solo obtiene la respuesta, no tiene status
                resp?.let {
                    val superHeroDetailEntity = it.transformToDetailEntity()
                    videojuegosDAO.insertSuperHeroDetails(superHeroDetailEntity)
                }
            }
        } catch (exception: Exception) {
            Log.e("catch", "")
        }
    }
}

