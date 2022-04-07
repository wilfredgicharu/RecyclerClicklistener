package com.example.lesson44pratice.Adapter

import android.app.TaskStackBuilder.create
import android.content.IntentFilter.create
import android.media.MediaPlayer.create
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.customview.widget.ViewDragHelper.create
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson44pratice.Adapter.MyAdapter.Type.ADVERTISMENT
import com.example.lesson44pratice.Adapter.MyAdapter.Type.ITEM
import com.example.lesson44pratice.ViewHolders.BaseViewHolder
import com.example.lesson44pratice.Model.Item
import com.example.lesson44pratice.ViewHolders.AdViewHolder
import com.example.lesson44pratice.ViewHolders.AdViewHolder.Companion.create
import com.example.lesson44pratice.ViewHolders.MyViewHolder
import java.net.URI.create
import java.util.*

class MyAdapter (private val listener: AdapterView.OnItemClickListener) :
    RecyclerView.Adapter<BaseViewHolder<Any>>() {
    private val items = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return when(viewType){
            ITEM -> MyViewHolder.create(parent, listener)
            else -> AdViewHolder.create(parent, listener) // ADVERTISMENT

        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {
        TODO("Not yet implemented")
    }
    //Displaying the items
    fun setNewItems (newItems: List<Any>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is String -> ADVERTISMENT
            is Item -> ITEM
            else-> -1
        }
    }
    object Type {
        const val ITEM = 0
        const val ADVERTISMENT = 1
    }
    //When the items clicked
    interface OnClickListener{
        fun onItemClick(position: Int)
        fun onAdClick(position: Int)
        fun onButtonClick(position: Int)
    }
}