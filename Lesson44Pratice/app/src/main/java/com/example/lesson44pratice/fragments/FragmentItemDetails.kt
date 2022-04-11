package com.example.lesson44pratice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.lesson44pratice.Model.Data
import com.example.lesson44pratice.R


class FragmentItemDetails : Fragment(R.layout.fragment_item_details) {
    lateinit var iv_detail_icon: ImageView
    lateinit var tv_detail_name: TextView
    lateinit var tv_detail_creator: TextView
    lateinit var tv_detail_description: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_detail_icon = view.findViewById(R.id.iv_detail_icon)
        tv_detail_name = view.findViewById(R.id.tv_detail_name)
        tv_detail_creator = view.findViewById(R.id.tv_detail_creator)
        tv_detail_description = view.findViewById(R.id.tv_detail_description)
        setup()
    }

    private fun setup() {
        val idFromArgs = arguments?.getLong(Long::class.java.canonicalName)

        idFromArgs?.let { id ->
            val details = Data.itemDetails.find { it.id == id }

            details?.let {
                iv_detail_icon.setImageResource(details.icon)
                tv_detail_name.text = details.name
                tv_detail_creator.text = details.creator
                tv_detail_description.text = details.description
            }
        }
    }

    companion object {
        fun newInstance(id: Long): FragmentItemDetails {
            val bundle = Bundle().apply {
                putLong(Long::class.java.canonicalName, id)
            }
            return FragmentItemDetails().apply { arguments = bundle }
        }
    }
}