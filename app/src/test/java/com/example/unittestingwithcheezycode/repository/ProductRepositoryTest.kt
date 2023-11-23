package com.example.unittestingwithcheezycode.repository

import com.example.unittestingwithcheezycode.api.ProductAPI
import com.example.unittestingwithcheezycode.model.ProductListItem
import com.example.unittestingwithcheezycode.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class ProductRepositoryTest {

    @Mock
    lateinit var productAPI: ProductAPI

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGetProducts_EmptyList() = runTest {
        Mockito.`when`(productAPI.getProducts()).thenReturn(Response.success(emptyList()))
        val sut = ProductRepository(productAPI)
        val result = sut.getProducts()
        Assert.assertEquals(true, result is NetworkResult.Success)
        Assert.assertEquals(0, result.data!!.size)
    }

    @Test
    fun testGetProducts_expectedProductList() = runTest {
        val productList = listOf<ProductListItem>(
            ProductListItem(1, "Prod 1", 40.3, "", "", ""),
            ProductListItem(2, "Prod 2", 40.3, "", "", "")
        )

        Mockito.`when`(productAPI.getProducts()).thenReturn(Response.success(productList))

        val sut = ProductRepository(productAPI)
        val result = sut.getProducts()
        Assert.assertEquals(true, result is NetworkResult.Success)
        Assert.assertEquals(2, result.data!!.size)
        Assert.assertEquals("Prod 1", result.data!![0].title)
    }

    @Test
    fun testGetProducts_expectedError() = runTest {
        Mockito.`when`(productAPI.getProducts()).thenReturn(Response.error(401, "Unauthorized".toResponseBody()))

        val sut = ProductRepository(productAPI)
        val result = sut.getProducts()
        Assert.assertEquals(true, result is NetworkResult.Error)
        Assert.assertEquals("Something went wrong", result.message)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}