package com.example.thecatapp.data

import com.example.thecatapp.BASE_URL
import com.example.thecatapp.model.Cat
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(CatApi::class.java)

    suspend fun getCats(): List<Cat> {
        return api.getAllCats("bda53789-d59e-46cd-9bc4-2936630fde39")
    }

}