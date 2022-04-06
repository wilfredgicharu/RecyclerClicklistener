package com.example.lesson44pratice.Model

import android.content.ClipData
import com.example.lesson44pratice.R

object Data {
    val items = listOf<Item>(
        Item(1, "Java", R.drawable.ic_baseline_train_24),
        Item(2, "Kotlin", R.drawable.ic_baseline_stars_24),
        Item(3, "Dart", R.drawable.ic_baseline_network_check_24)
            )

    val itemDetails = listOf<ItemDetails>(
        ItemDetails(1, "Java", R.drawable.ic_baseline_train_24, "Sun MacroSystems", "One of the most hated languages"),
        ItemDetails(2, "Kotlin", R.drawable.ic_baseline_stars_24, "Jet Brains", "Basically sugar coated Java"),
        ItemDetails(3, "Dart", R.drawable.ic_baseline_network_check_24, "Google", "One language to rule them all")
    )
    fun getLongListItems(): MutableList<Any>{
        val list = mutableListOf<Any>()
        //Display the list in a hundred lists
        for (i in 1..100){
            list.addAll(list)
            //if the list reaches a figure divisible by 3
            if (i % 3 ==0){
                list.add("https://dart.dev/tutorials")
            }
        }
        return list
    }
}
