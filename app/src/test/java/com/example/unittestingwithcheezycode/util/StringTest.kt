package com.example.unittestingwithcheezycode.util

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class StringTest {

    private lateinit var utils: Utils

    @Before
    fun before() {
        utils = Utils()
    }

    @Test
    fun testStringReversal_empty_string_expected_empty_string() {
        val result = utils.reverseString("")
        assertEquals("", result)
    }

    @Test
    fun testStringReversal_single_char_expected_single_char() {
        val result = utils.reverseString("a")
        assertEquals("a", result)
    }

    @Test
    fun testStringReversal_valid_input_expected_same_string() {
        val result = utils.reverseString("ABCDE")
        assertEquals("EDCBA", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal_null_value_expected_exception() {
        val result = utils.reverseString(null)
    }
}