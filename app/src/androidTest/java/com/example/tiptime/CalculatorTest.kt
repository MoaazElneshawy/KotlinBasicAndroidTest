package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// 1- Specify the test runner => which runs the test on the device or emulator
@RunWith(AndroidJUnit4::class)
class CalculatorTest {

    // 2- specify the activity you need to test
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    // 3- write your test case
    @Test
    fun calculate_20_tip() {
        onView(withId(R.id.etCostOfService))
            .perform(typeText("50.00")) //typeText => setText("50")
            .perform(closeSoftKeyboard())

        onView(withId(R.id.btnCalculate))
            .perform(click())

        onView(withId(R.id.tvTipAmount))
            .check(matches(withText(containsString("$10.00"))))
    }

    @Test
    fun calculate_18_tip() {
        onView(withId(R.id.etCostOfService))
            .perform(typeText("50.00"))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.rbGood))
            .perform(click())

        onView(withId(R.id.btnCalculate))
            .perform(click())

        onView(withId(R.id.tvTipAmount))
            .check(matches(withText(containsString("$9.00"))))
    }

    @Test
    fun calculate_15_tip() {
        onView(withId(R.id.etCostOfService))
            .perform(typeText("50.00"))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.rbOk))
            .perform(click())

        onView(withId(R.id.btnCalculate))
            .perform(click())

        onView(withId(R.id.tvTipAmount))
            .check(matches(withText(containsString("$8.00"))))
        // the value will be ceil up from 7.5 to 8.0
    }


}