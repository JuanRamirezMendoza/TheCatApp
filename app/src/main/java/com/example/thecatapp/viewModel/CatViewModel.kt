package com.example.thecatapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecatapp.model.Cat
import kotlinx.coroutines.launch

class CatViewModel: ViewModel() {

    private val repository = GetRepository()

    private val _cats = MutableLiveData<List<Cat>>()
    val cats: LiveData<List<Cat>> = _cats

    fun loadCats() {
        viewModelScope.launch {
            try {
                _cats.value = repository.getCats()
            } catch (e: Exception) {
                Log.e("BreedViewModel", e.message, e)
            }
        }
    }
}