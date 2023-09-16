package com.demo.mvvmdaggerkotlindemo.util

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.ViewInteraction

// Assuming you have a reference to your RecyclerView
val recyclerView = activityRule.activity.findViewById<RecyclerView>(R.id.recyclerViewId) // Replace with your RecyclerView's ID

// Perform a click action on the button within the item that contains the text "Chilled"
onView(withId(R.id.recyclerViewId)).perform(
actionOnItem<YourAdapter.ParentViewHolder>(
hasDescendant(withText("SomeText")),
customAction(clickChildViewWithId(R.id.buttonId))
)
)

// Define a custom action to find and click the button by its ID
fun clickChildViewWithId(viewId: Int): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return allOf(isAssignableFrom(View::class.java), isDisplayed())
        }

        override fun getDescription(): String {
            return "Click on a child view with specified ID."
        }

        override fun perform(uiController: UiController?, view: View?) {
            val button = view?.findViewById<View>(viewId)
            button?.performClick()
        }
    }
}
