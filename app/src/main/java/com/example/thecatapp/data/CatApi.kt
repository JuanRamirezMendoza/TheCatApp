package com.example.thecatapp.data

import com.example.thecatapp.GET_BREEDS
import com.example.thecatapp.model.Cat
import retrofit2.http.GET
import retrofit2.http.Header

interface CatApi {
    @GET(GET_BREEDS)
    suspend fun getAllCats(@Header("x-api-key") apiKey: String):List<Cat>
}