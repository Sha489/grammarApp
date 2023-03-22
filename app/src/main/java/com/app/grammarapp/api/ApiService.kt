package com.app.grammarapp.api

import com.app.grammarapp.api.Endpoints
import com.app.grammarapp.api.model.English
import com.app.grammarapp.api.model.QueryParams
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST(Endpoints.Apis.COMPLETIONS)
    @Headers("Content-Type:application/json", "Authorization: Bearer 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")
    suspend fun improEnglishAPI(@Body body: QueryParams): Response<English>
}
