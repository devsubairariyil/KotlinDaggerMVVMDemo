package com.demo.mvvmdaggerkotlindemo.util

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnHolderItem
import androidx.test.espresso.matcher.ViewMatchers.withText

// Replace with the actual ID of your RecyclerView
val recyclerView = activityRule.activity.findViewById<RecyclerView>(R.id.recyclerViewId)

// Text you want to find and scroll to
val textToScrollTo = "Your Text Here"

// Create a custom matcher to find the item with the specified text
val itemMatcher = withText(textToScrollTo)

// Create a custom action to scroll to the item
val scrollToAction = actionOnHolderItem(
    CustomViewHolderMatcher(itemMatcher),
    scrollTo()
)

// Scroll to the item with the specified text
onView(withId(R.id.recyclerViewId)).perform(scrollToAction)

// Define a custom ViewHolder matcher that matches by text
class CustomViewHolderMatcher(private val matcher: Matcher<View>) :
    BoundedMatcher<RecyclerView.ViewHolder, YourAdapter.ViewHolder>(
        YourAdapter.ViewHolder::class.java
    ) {

    override fun describeTo(description: Description?) {
        description?.appendText("with text: ")
        matcher.describeTo(description)
    }

    override fun matchesSafely(item: YourAdapter.ViewHolder?): Boolean {
        return item?.itemView != null && matcher.matches(item.itemView)
    }
}
