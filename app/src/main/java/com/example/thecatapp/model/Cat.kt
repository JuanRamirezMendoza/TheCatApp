package com.example.thecatapp.model

import com.google.gson.annotations.SerializedName

class Cat(
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: String,
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("reference_image_id") val image: String
)