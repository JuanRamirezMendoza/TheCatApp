package com.example.thecatapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thecatapp.databinding.CatAdapterBinding
import com.example.thecatapp.model.Cat
import com.squareup.picasso.Picasso

class CatAdapter(
    var list: List<Cat> = mutableListOf()
) : RecyclerView.Adapter<CatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        CatAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: CatAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cat) {
            binding.catName.text = cat.name
            Picasso.get().load(cat.image)
                .into(binding.catImage)
            binding.catOrigin.text = cat.origin
            binding.catIntelligence.text = cat.intelligence

        }
    }
}