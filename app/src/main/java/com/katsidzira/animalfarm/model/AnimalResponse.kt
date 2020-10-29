package com.katsidzira.animalfarm.model

import com.google.gson.annotations.SerializedName

data class AnimalResponse(
    @SerializedName("animals")
    val animalResponse: List<Animal>
)