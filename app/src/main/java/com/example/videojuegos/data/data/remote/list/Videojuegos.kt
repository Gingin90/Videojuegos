package com.example.videojuegos.data.remote.list

import com.google.gson.annotations.SerializedName

data class Videojuegos(
   @SerializedName("id") val id: Int,
   @SerializedName("nombre") val name: String,
   @SerializedName("origen") val origin: String,
   @SerializedName("imagenLink")val imageUrl: String,
   @SerializedName("poder")val superPower: String,
   @SerializedName("Año_creacion")val year: Int
)