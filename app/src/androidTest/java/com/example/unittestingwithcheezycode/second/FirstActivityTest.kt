package com.example.unittestingwithcheezycode.second


import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import org.junit.Test
import com.example.unittestingwithcheezycode.R

class FirstActivityTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<FirstActivity>()

    @Test
    fun testSubmit_expectedCorrectValues() {
        onView(withId(R.id.editTitle)).perform(typeText("Hello"))
        onView(withId(R.id.editDescription)).perform(typeText("Shailesh"), closeSoftKeyboard())

        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withId(R.id.text)).check(matches(ViewMatchers.withText("Hello || Shailesh")))
    }
}