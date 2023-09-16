package com.demo.mvvmdaggerkotlindemo.util

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions

// Replace with the actual ID of your RecyclerView
val recyclerView = activityRule.activity.findViewById<RecyclerView>(R.id.recyclerViewId)

// Text you want to find in the RecyclerView
val textToFind = "Your Text Here"

// Perform a search for the text in the RecyclerView
val position = getPositionForText(recyclerView, textToFind)

// Scroll to the item at the found position
Espresso.onView(ViewMatchers.withId(R.id.recyclerViewId))
.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))

// Define a function to find the position of an item by text
fun getPositionForText(recyclerView: RecyclerView, targetText: String): Int {
    val adapter = recyclerView.adapter ?: return RecyclerView.NO_POSITION
    val itemCount = adapter.itemCount

    for (position in 0 until itemCount) {
        val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
        if (viewHolder is YourAdapter.ViewHolder) { // Replace with your actual ViewHolder class
            val itemView = viewHolder.itemView
            // Replace with the actual ID of the TextView where the text is displayed
            val textView = itemView.findViewById<TextView>(R.id.textViewId)
            val itemText = textView.text.toString()
            if (itemText == targetText) {
                return position
            }
        }
    }

    return RecyclerView.NO_POSITION // Return NO_POSITION if the text is not found
}
