package com.example.unittestingwithcheezycode.model

import com.google.gson.annotations.SerializedName

data class ProductListItem(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("image") var image: String? = null,
)