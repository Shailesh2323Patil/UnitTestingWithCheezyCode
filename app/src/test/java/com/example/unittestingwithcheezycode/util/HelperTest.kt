package com.example.unittestingwithcheezycode.util

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper

    @Before
    fun setUp() {
        helper = Helper()
    }

    @After
    fun tearDown() {
        println("After Every Test Case")
    }

    @Test
    fun isPalindrome() {
        // Act
        val result = helper.isPalindrome("hello")
        // Assert
        assertEquals(false, result)
    }

    @Test
    fun isPalindrome_input_string_level_expected_true() {
        // Act
        val result = helper.isPalindrome("level")
        // Assert
        assertEquals(true, result)
    }
}