package com.example.thecatapp.viewModel

import com.example.thecatapp.data.CatService
import com.example.thecatapp.model.Cat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRepository {

    suspend fun getCats(): List<Cat> {
        return withContext(Dispatchers.IO) {
            CatService.getCats()
        }
    }

}