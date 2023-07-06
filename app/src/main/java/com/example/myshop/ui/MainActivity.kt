package com.example.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.ProductViewModel
import com.example.myshop.model.ProductResponse
import com.example.myshop.api.ApiClient
import com.example.myshop.api.ApiInterface
import com.example.myshop.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val productViewModel:ProductViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        productViewModel.fetchProducts()

        productViewModel.productsLiveData.observe(this, Observer{ productList->
            Toast
                .makeText(baseContext,"fetched ${productList?.size}products",Toast.LENGTH_LONG)
                .show()
        })
        productViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG)
        })
    }
    }