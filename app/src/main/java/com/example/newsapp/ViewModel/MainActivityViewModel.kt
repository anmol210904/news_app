package com.example.newsapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.Repository.NewsRepository
import com.example.newsapp.models.news
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(val newsRepository: NewsRepository) : ViewModel() {
    val healthNewsData: LiveData<news>
        get() = newsRepository.healthNewsData

    val entertainmentNewsData: LiveData<news>
        get() = newsRepository.entertainmentNewsData

    val generalNewsData: LiveData<news>
        get() = newsRepository.generalNewsData

    val businessNewsData: LiveData<news>
        get() = newsRepository.businessNewsData

    val scienceNewsData: LiveData<news>
        get() = newsRepository.scienceNewsData

    val sportsNewsData: LiveData<news>
        get() = newsRepository.sportsNewsData

    val technologyNewsData: LiveData<news>
        get() = newsRepository.technologyNewsData

    init {
        CoroutineScope(Dispatchers.IO).launch {
            fetchNews()
        }
    }

    private suspend fun fetchNews() {
        // Create a coroutine scope
        CoroutineScope(Dispatchers.Main).launch {
            newsRepository.fetchBusinessNews()
        }
        CoroutineScope(Dispatchers.Main).launch {
            newsRepository.fetchGeneralNews()
        }
        CoroutineScope(Dispatchers.Main).launch {
            newsRepository.fetchScienceNews()
        }
        CoroutineScope(Dispatchers.Main).launch {
            newsRepository.fetchSportsNews()
        }
        CoroutineScope(Dispatchers.Main).launch {
            newsRepository.fetchEntertainmentNews()
        }
        CoroutineScope(Dispatchers.Main).launch {
            newsRepository.fetchTechnologyNews()
        }
        CoroutineScope(Dispatchers.Main).launch {
            newsRepository.fetchScienceNews()
        }

        CoroutineScope(Dispatchers.Main).launch {
            newsRepository.fetchHealthNews()
        }

        CoroutineScope(Dispatchers.Main).launch {
            newsRepository.fetchGeneralNews()
        }

    }

}