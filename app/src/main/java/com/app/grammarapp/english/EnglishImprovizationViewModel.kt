package com.app.grammarapp.english

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.grammarapp.api.ApiService
import com.app.grammarapp.api.model.QueryParams
import com.app.grammarapp.api.model.English
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EnglishImprovizationViewModel constructor(val apiService: ApiService) : ViewModel()  {
    var response : MutableLiveData<English> = MutableLiveData()

    suspend fun ImproEnglishAPI(queryParams: QueryParams) {
        withContext(Dispatchers.IO) {
            try {
                response.postValue(apiService.improEnglishAPI(queryParams).body()!!)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

