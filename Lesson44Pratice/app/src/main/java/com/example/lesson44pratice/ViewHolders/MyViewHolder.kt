package com.example.lesson44pratice.ViewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson44pratice.Adapter.MyAdapter
import com.example.lesson44pratice.Model.Item
import com.example.lesson44pratice.R
import java.time.DayOfWeek.from
import java.util.Date.from

class MyViewHolder(itemView: View): BaseViewHolder<Any>(itemView) {

    companion object {
        fun create(parent: ViewGroup, listener: MyAdapter.OnClickListener): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_my_viewholder, parent, false)
            val holder = MyViewHolder(view)
            holder.itemView.setOnClickListener {
                listener.onItemClick(holder.adapterPosition)
            }

            holder.itemView.run {
                val button = findViewById<Button>(R.id.button)
                button.setOnClickListener {
                    listener.onButtonClick(holder.adapterPosition)
                }
            }

            return holder
        }
    }

    override fun bind(item: Any) {
        item as Item
        itemView.run {
            val iv_icon= findViewById<ImageView>(R.id.iv_icon)
            val tv_name = findViewById<TextView>(R.id.tv_name)
            iv_icon.setImageResource(item.icon)
            tv_name.text = item.name
        }
    }
}