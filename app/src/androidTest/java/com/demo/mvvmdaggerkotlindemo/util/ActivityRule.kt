package com.demo.mvvmdaggerkotlindemo.util

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule

class MyActivityTestRule : ActivityScenarioRule<MyActivity>(MyActivity::class.java) {
    // Additional setup or customization if needed
}
class MyEspressoTest {

    // Reference to the MyActivityTestRule instance
    @get:Rule
    val activityRule = MyActivityTestRule()

    @Test
    fun myEspressoTest() {
        // Your Espresso test code here
        Espresso.onView(withId(R.id.someViewId)).perform(...) // Replace with your test actions
    }
}