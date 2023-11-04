package com.example.videojuegos.data.data

import com.example.superheroescomics.data.local.detail.SuperHeroDetailEntity
import com.example.videojuegos.data.data.local.list.VideojuegoEntity
import com.example.videojuegos.data.data.remote.list.Videojuegos
import com.example.videojuegos.data.data.remote.detail.SuperHeroDetail

fun Videojuegos.transformToEntity(): VideojuegoEntity =
    VideojuegoEntity(this.id, this.name, this.origin, this.imageUrl, this.superPower, this.year)

fun SuperHeroDetail.transformToDetailEntity(): SuperHeroDetailEntity =
    SuperHeroDetailEntity(
        this.id,
        this.name,
        this.origin,
        this.imageUrl,
        this.superPower,
        this.year,
        this.color,
        this.translate
    )
