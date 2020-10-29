package com.katsidzira.animalfarm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.katsidzira.animalfarm.model.AnimalResponse
import com.katsidzira.animalfarm.network.AnimalApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, host)
            .setPrimaryNavigationFragment(host)
            .commit()

        val TAG = "main activity"

        val animalApi = AnimalApi.create()
        animalApi.getAnimalApiResponse().enqueue(object : Callback<AnimalResponse> {
            override fun onResponse(
                call: Call<AnimalResponse>,
                response: Response<AnimalResponse>
            ) {
                Log.d(TAG, "response=${response.body()!!.animalResponse[0].name}")
            }

            override fun onFailure(call: Call<AnimalResponse>, t: Throwable) {
                Log.d(TAG, "error: ${t.message}")
            }

        })
    }
}