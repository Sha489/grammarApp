package com.app.grammarapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.grammarapp.api.ApiService
import com.app.grammarapp.english.EnglishImprovizationViewModel

class MyViewModelFactory(val apiService: ApiService) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when(modelClass){
        EnglishImprovizationViewModel::class.java -> EnglishImprovizationViewModel(apiService)
        else -> throw IllegalArgumentException("Unknown ViewModel class")
    } as T
}

