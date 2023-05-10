package com.example.mvvm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_retrofit.api.QuoteService
import com.example.mvvm_retrofit.api.RetrofitHelper
import com.example.mvvm_retrofit.repository.QouteRepository
import com.example.mvvm_retrofit.viewmodels.MainViewModel
import com.example.mvvm_retrofit.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("Usman Data",it.results.toString())
            Toast.makeText(this,it.results.size.toString(),Toast.LENGTH_SHORT).show()
        })

        
    }
}