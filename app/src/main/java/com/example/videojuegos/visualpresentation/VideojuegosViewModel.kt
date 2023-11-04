package com.example.videojuegos.visualpresentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.videojuegos.data.data.Repository
import com.example.videojuegos.data.data.local.VideojuegosDatabase
import com.example.videojuegos.data.data.remote.VideojuegosRetrofit
import com.example.videojuegos.data.local.VideojuegosDAO

import kotlinx.coroutines.launch

class VideojuegosViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val api = VideojuegosRetrofit.getVideojuegosRetrofit()
        val VideojuegosDatabase: VideojuegosDAO =
            VideojuegosDatabase.getDataBase(application).getVideojuegosDAO()
        repository = Repository(api, videojuegosDataBase)
    }

    //Lista
    fun superHeroesLiveData() = repository.getSuperHeroesFromEntity()

    fun getSuperHeroesViewModel() = viewModelScope.launch { repository.getVideojuegos() }

    //Detalle
    fun superHeroDetailLiveData(id: Int) = repository.getSuperHeroDetailsFromEntity(id)

    fun superHeroDetailsViewModel(id: Int) =
        viewModelScope.launch { repository.getVideojuegosDetails(id) }
}