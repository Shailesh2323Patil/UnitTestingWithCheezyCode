package com.example.unittestingwithcheezycode.util

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class PasswordTest {

    private lateinit var utils: Utils

    @Before
    fun before() {
        utils = Utils()
    }

    @Test
    fun isValidPassword_blank_input_expected_required_fields() {
        val result = utils.isValidPassword("  ")
        assertEquals("Password is Required", result)
    }

    @Test
    fun isValidPassword_blank_input_expected_validation_msg() {
        val result = utils.isValidPassword("ab")
        assertEquals("Length Of Password Should be Greater than 6", result)
    }

    @Test
    fun isValidPassword_blank_input_expected_valid_password() {
        val result = utils.isValidPassword("ab@1234")
        assertEquals("Valid", result)
    }
}