package com.example.videojuegos.data.local.detail

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video_juegos_detail_table")
data class VideojuegosDetailEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val origin: String,
    val imageUrl: String,
    val description:String,
    val year: Int,
    val manual: Boolean
)
