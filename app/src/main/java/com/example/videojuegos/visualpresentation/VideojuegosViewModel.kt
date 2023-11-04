package com.example.videojuegos.visualpresentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.videojuegos.data.Repository
import com.example.videojuegos.data.local.VideojuegosDAO
import com.example.videojuegos.data.local.VideojuegosDatabase
import com.example.videojuegos.data.remote.VideojuegosRetrofit

import kotlinx.coroutines.launch

class VideojuegosViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val api = VideojuegosRetrofit.getVideojuegosRetrofit()
        val VideojuegosDatabase: VideojuegosDAO =
            VideojuegosDatabase.getDataBase(application).getVideojuegosDAO()
        repository = Repository(api, videojuegosDatabase)
    }

    //Lista
    fun superHeroesLiveData() = repository.getVideojuegosFromEntity()

    fun getSuperHeroesViewModel() = viewModelScope.launch { repository.getVideojuegos() }

    //Detalle
    fun superHeroDetailLiveData(id: Int) = repository.getVideojuegosDetailsFromEntity(id)

    fun superHeroDetailsViewModel(id: Int) =
        viewModelScope.launch { repository.getVideojuegosDetails(id) }
}