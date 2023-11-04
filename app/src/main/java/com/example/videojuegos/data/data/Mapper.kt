package com.example.videojuegos.data



import com.example.videojuegos.data.local.detail.VideojuegosDetailEntity
import com.example.videojuegos.data.local.list.VideojuegoEntity
import com.example.videojuegos.data.remote.detail.VideojuegosDetail
import com.example.videojuegos.data.remote.list.Videojuegos


fun Videojuegos.transformToEntity(): VideojuegoEntity =
    VideojuegoEntity(this.id, this.name, this.origin, this.imageUrl, this.year)

fun VideojuegosDetail.transformToDetailEntity(): VideojuegosDetailEntity = VideojuegosDetailEntity(
        this.id,
        this.name,
        this.origin,
        this.imageUrl,
        this.year,)
