package com.example.videojuegos.data.data.remote.detail

import com.google.gson.annotations.SerializedName

data class VideojuegosDetail(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val name: String,
    @SerializedName("origen") val origin: String,
    @SerializedName("imagenLink") val imageUrl: String,
    @SerializedName("poder") val superPower: String,
    @SerializedName("año_creacion") val year: Int,
    @SerializedName("color") val color: String,
    @SerializedName("traduccion") val translate: Boolean
    com.example.videojuegos
)