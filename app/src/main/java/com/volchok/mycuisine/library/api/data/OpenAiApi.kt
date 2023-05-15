package com.volchok.mycuisine.library.api.data

import retrofit2.http.Header

interface OpenAiApi {
    suspend fun getOpenAiChat(@Header("content-type")type: String, @Header("X-RapidAPI-Key")key: String, @Header("X-RapidAPI-Host")host: String)
}