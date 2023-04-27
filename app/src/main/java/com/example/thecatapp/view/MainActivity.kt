package com.example.thecatapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thecatapp.databinding.ActivityMainBinding
import com.example.thecatapp.viewModel.CatViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val catViewModel : CatViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CatAdapter(emptyList())
        binding.recyclerViewCat.adapter = adapter
        binding.recyclerViewCat.layoutManager = LinearLayoutManager(this)

        catViewModel.cats.observe(this) { breeds ->
            adapter.list = breeds
            adapter.notifyDataSetChanged()
        }

        catViewModel.loadCats()

    }

}