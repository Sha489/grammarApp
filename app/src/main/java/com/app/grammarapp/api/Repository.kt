package com.app.grammarapp.api

import com.app.grammarapp.api.Endpoints
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset

object Repository {
    fun getClient(): Retrofit? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor)
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                val request = chain.request()
                val response = chain.proceed(request)
                val responseBody = response.body
                val source = responseBody!!.source()
                source.request(Long.MAX_VALUE) // Buffer the entire body.
                val buffer = source.buffer()
                val respData =
                    buffer.clone().readString(Charset.defaultCharset())
                var resp: JSONObject? = null
                try {
                    resp = JSONObject(respData)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                response
            }).build()
        return Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}