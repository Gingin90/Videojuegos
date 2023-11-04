package com.example.videojuegos.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.videojuegos.data.local.detail.VideojuegosDetailEntity
import com.example.videojuegos.data.local.list.VideojuegoEntity

@Dao
interface VideojuegosDAO {
    //Lista
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideoJuegos(videojuegoEntity: List<VideojuegoEntity>)

    @Query("Select * from video_juegos_table order by id ASC")
    fun getVideojueos(): LiveData<List<VideojuegoEntity>>

    //Detalle
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideojuegosDetails(superHeroDetailEntity: VideojuegosDetailEntity)

    @Query("Select * from video_juegos_detail_table WHERE id = :id")
    fun getVideojuegosDetails(id: Int): LiveData<VideojuegosDetailEntity>
}