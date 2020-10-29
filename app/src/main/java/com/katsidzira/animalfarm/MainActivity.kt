package com.katsidzira.animalfarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.katsidzira.animalfarm.model.AnimalResponse
import com.katsidzira.animalfarm.network.AnimalApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TAG = "main activity"

        val animalApi = AnimalApi.create()
        animalApi.getAnimalApiResponse().enqueue(object : Callback<AnimalResponse> {
            override fun onResponse(call: Call<AnimalResponse>, response: Response<AnimalResponse>) {
                Log.d(TAG, "response=${response.body()!!.animalResponse[0].name}")
            }

            override fun onFailure(call: Call<AnimalResponse>, t: Throwable) {
                Log.d(TAG, "error: ${t.message}")
            }

        })
    }
}