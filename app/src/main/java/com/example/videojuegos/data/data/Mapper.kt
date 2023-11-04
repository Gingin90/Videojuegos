package com.example.videojuegos.data.data


import com.example.videojuegos.data.data.local.detail.VideojuegosDetailEntity
import com.example.videojuegos.data.data.local.list.VideojuegoEntity
import com.example.videojuegos.data.data.remote.detail.VideojuegosDetail
import com.example.videojuegos.data.data.remote.list.Videojuegos


fun Videojuegos.transformToEntity(): VideojuegoEntity =
    VideojuegoEntity(this.id, this.name, this.origin, this.imageUrl, this.superPower, this.year)

fun VideojuegosDetail.transformToDetailEntity(): VideojuegosDetailEntity = VideojuegosDetailEntity(
        this.id,
        this.name,
        this.origin,
        this.imageUrl,
        this.year,
    )
