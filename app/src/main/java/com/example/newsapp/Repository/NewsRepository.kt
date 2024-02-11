package com.example.newsapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.APIServices.APIinterface
import com.example.newsapp.models.news

class NewsRepository(private val apiInterface : APIinterface) {
    private val healthNewsLiveData = MutableLiveData<news>()
    val healthNewsData : LiveData<news>
        get() = healthNewsLiveData

    private val entertainmentNewsLiveData =  MutableLiveData<news>()
    val entertainmentNewsData : LiveData<news>
        get() = entertainmentNewsLiveData


    private val generalNewsLiveData = MutableLiveData<news>()
    val generalNewsData : LiveData<news>
        get() = generalNewsLiveData

    private val businessNewsLiveData = MutableLiveData<news>()
    val businessNewsData : LiveData<news>
        get() = businessNewsLiveData

    private val scienceNewsLiveData = MutableLiveData<news>()
    val scienceNewsData : LiveData<news>
        get() = scienceNewsLiveData

    private val sportsNewsLiveData = MutableLiveData<news>()
    val sportsNewsData : LiveData<news>
        get() = sportsNewsLiveData

    private val technologyNewsLiveData = MutableLiveData<news>()
    val technologyNewsData : LiveData<news>
        get() = technologyNewsLiveData


    suspend fun fetchHealthNews() {
        val result = apiInterface.getNewsHealth()
        if (result.body() != null) {
            healthNewsLiveData.postValue(result.body())
        }
    }

    suspend fun fetchEntertainmentNews() {
        val result = apiInterface.getNewsEntertainment()
        if (result.body() != null) {
            entertainmentNewsLiveData.postValue(result.body())
        }
    }

    suspend fun fetchGeneralNews() {
        val result = apiInterface.getNewsGeneral()
        if (result.body() != null) {
            generalNewsLiveData.postValue(result.body())
        }
    }

    suspend fun fetchBusinessNews() {
        val result = apiInterface.getNewsBusiness()
        if (result.body() != null) {
            businessNewsLiveData.postValue(result.body())
        }
    }

    suspend fun fetchScienceNews() {
        val result = apiInterface.getNewsScience()
        if (result.body() != null) {
            scienceNewsLiveData.postValue(result.body())
        }
    }

    suspend fun fetchSportsNews() {
        val result = apiInterface.getNewsSports()
        if (result.body() != null) {
            sportsNewsLiveData.postValue(result.body())
        }
    }

    suspend fun fetchTechnologyNews() {
        val result = apiInterface.getNewsTechnology()
        if (result.body() != null) {
            technologyNewsLiveData.postValue(result.body())
        }
    }





}