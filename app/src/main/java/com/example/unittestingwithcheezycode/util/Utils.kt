package com.example.unittestingwithcheezycode.util

import java.lang.IllegalArgumentException

class Utils {
    fun isValidPassword(input: String) : String {
        return when {
            input.isBlank() -> {
                "Password is Required"
            }
            input.length < 6 -> {
                "Length Of Password Should be Greater than 6"
            }
            input.length > 15 -> {
                "Length Of Password Should be Less than 15"
            }
            else -> {
                "Valid"
            }
        }
    }

    fun reverseString(input: String?): String {
        if(input == null) {
            throw IllegalArgumentException("Input String is Required")
        }

        var chars = input.toCharArray()
        var i = 0
        var j = chars.size - 1

        while(i<j) {
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }

        return chars.joinToString("")
    }
}