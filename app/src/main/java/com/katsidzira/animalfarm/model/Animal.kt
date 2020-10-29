package com.katsidzira.animalfarm.model

import com.google.gson.annotations.SerializedName

data class Animal(
        @SerializedName("name")
        val name: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("fact")
        val fact: String
)
