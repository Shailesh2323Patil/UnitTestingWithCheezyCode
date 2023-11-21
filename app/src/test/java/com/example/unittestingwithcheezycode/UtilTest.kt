package com.example.unittestingwithcheezycode

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class UtilTest {

    /**
     * 1) This Dispatcher Replace MainDispatcher with TestDispatcher
     * 2) StandardTestDispatcher handles the multiple coroutine on Single Thread,
     * because Test Cases need not wait for Delay.
     * */
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        /**
         * This line is for convert Main Dispatcher into Test Dispatcher
         * */
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getUserName() {
        val sut = Util(testDispatcher)
        /**
         * runTest Generally use for Test the Coroutine in Testing Environment
         * */
        runTest {
            sut.getUserName()
        }
    }

    @Test
    fun getUser() {
        val sut = Util(testDispatcher)
        runTest {
            sut.getUser()
        }
    }

    @Test
    fun getAddress() {
        /**
         * Here We have pass the "testDispatcher"
         * Because getAddress() function Util Class required dispatcher
         * to Run. But we Handle this by Rule also for Multiple Use.
         * For Ex. Check the MainCoroutineRule
         * */
        val sut = Util(testDispatcher)
        runTest {
            sut.getAddress()
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}