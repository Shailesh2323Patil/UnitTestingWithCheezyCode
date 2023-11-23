package com.example.unittestingwithcheezycode.repository

import com.example.unittestingwithcheezycode.api.ProductAPI
import com.example.unittestingwithcheezycode.model.ProductListItem
import com.example.unittestingwithcheezycode.util.NetworkResult

class ProductRepository(private val productAPI: ProductAPI) {

    suspend fun getProducts() : NetworkResult<List<ProductListItem>> {
        val response = productAPI.getProducts()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if(responseBody != null) {
                NetworkResult.Success(responseBody)
            }
            else {
                NetworkResult.Error("Something went wrong")
            }
        } else {
            NetworkResult.Error("Something went wrong")
        }
    }

}