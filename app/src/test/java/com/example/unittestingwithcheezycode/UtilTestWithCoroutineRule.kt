package com.example.unittestingwithcheezycode

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class UtilTestWithCoroutineRule {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun getUser() {
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getUser()
        }
    }

    @Test
    fun getAddressDetail() {
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getAddressDetail()
            /**
             * This line is use for to Hold the Coroutine Until Result Come
             * */
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            Assert.assertEquals(true, sut.globalArg)
        }
    }
}