package com.example.unittestingwithcheezycode.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.unittestingwithcheezycode.getOrAwaitValue
import com.example.unittestingwithcheezycode.repository.ProductRepository
import com.example.unittestingwithcheezycode.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun test_GetProducts() = runTest {
        Mockito.`when`(repository.getProducts()).thenReturn(NetworkResult.Success(emptyList()))

        val sut = MainViewModel(repository)
        sut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.products.getOrAwaitValue()
        Assert.assertEquals(0, result.data!!.size)
    }

    @Test
    fun test_GetProducts_expectedError() = runTest {
        Mockito.`when`(repository.getProducts()).thenReturn(NetworkResult.Error("Something went wrong"))

        val sut = MainViewModel(repository)
        sut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.products.getOrAwaitValue()
        Assert.assertEquals(true, result is NetworkResult.Error)
        Assert.assertEquals("Something went wrong", result.message)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}