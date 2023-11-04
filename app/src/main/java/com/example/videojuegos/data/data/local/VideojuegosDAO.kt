package com.example.videojuegos.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superheroescomics.data.local.detail.SuperHeroDetailEntity
import com.example.videojuegos.data.data.local.list.VideojuegoEntity

@Dao
interface VideojuegosDAO {
    //Lista
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperHeroes(videojuegoEntity: List<VideojuegoEntity>)

    @Query("Select * from super_hero_table order by id ASC")
    fun getSuperHeroes(): LiveData<List<VideojuegoEntity>>

    //Detalle
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperHeroDetails(superHeroDetailEntity: SuperHeroDetailEntity)

    @Query("Select * from super_hero_detail_table WHERE id = :id")
    fun getSuperHeroDetails(id: Int): LiveData<SuperHeroDetailEntity>
}