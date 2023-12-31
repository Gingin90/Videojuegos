package com.example.videojuegos.data.local.list

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video_juegos_table")
data class VideojuegoEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val origin: String,
    val imageUrl: String,
    val description:String,
    val year: Int,
    val manual:Boolean,
)