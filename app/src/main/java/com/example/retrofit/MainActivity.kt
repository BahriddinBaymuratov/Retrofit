package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.UserAdapter
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.model.User
import com.example.retrofit.network.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val userAdapter by lazy { UserAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        callNewsApi()

    }

    private fun callNewsApi() {
        val retrofit = RetroInstance.retroInstance()
        retrofit.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful){
                    userAdapter.submitList(response.body())
                    binding.progressBar2.isVisible = false
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("@@@", "${t.message}")
            }
        })

    }
    private fun callGithubApi() {
        val retrofit = RetroInstance.retroInstance()
        retrofit.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    userAdapter.submitList(response.body())
                    binding.progressBar2.isVisible = false
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("@@@", "${t.message}")
            }
        })
    }

}