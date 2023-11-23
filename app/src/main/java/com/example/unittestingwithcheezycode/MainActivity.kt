package com.example.unittestingwithcheezycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unittestingwithcheezycode.adapter.ProductAdapter
import com.example.unittestingwithcheezycode.util.NetworkResult
import com.example.unittestingwithcheezycode.viewmodels.MainViewModel
import com.example.unittestingwithcheezycode.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductAdapter
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.productList)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val repository = (application as StoreApplication).productRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.getProducts()

        mainViewModel.products.observe(this, Observer {
            when (it) {
                is NetworkResult.Success -> {
                    adapter = ProductAdapter(it.data!!)
                    recyclerView.adapter = adapter
                }
                is NetworkResult.Error -> {}
                else -> {}
            }
        })
    }
}