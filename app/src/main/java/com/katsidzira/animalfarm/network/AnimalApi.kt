package com.katsidzira.animalfarm.network

import com.katsidzira.animalfarm.model.AnimalResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AnimalApi {

    @GET("/donChelsea/6619c69def9a1933ed4665c28dbf8452/raw/21557f6ece03b79fbf4ffba2f54e95f3e37cb563/animals2.json")
    fun getAnimalApiResponse(): Call<AnimalResponse>

    companion object {

        val BASE_URL = "https://gist.githubusercontent.com"

        fun create(): AnimalApi {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(AnimalApi::class.java)
        }
    }
}