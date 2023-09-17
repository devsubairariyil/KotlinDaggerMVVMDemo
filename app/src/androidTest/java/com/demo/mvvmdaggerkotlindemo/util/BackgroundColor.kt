package com.demo.mvvmdaggerkotlindemo.util

class BackgroundColor {
    fun test(){
        val expectedColor = Color.parseColor("#FF0000") // Replace with the color you expect

// Use Espresso to find the view by its ID and check its background color
        onView(withId(viewId))
            .check(matches(withBackgroundColor(equalTo(expectedColor))))
    }
}