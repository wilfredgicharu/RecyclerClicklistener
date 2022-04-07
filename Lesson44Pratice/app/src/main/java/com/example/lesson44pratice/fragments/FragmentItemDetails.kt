package com.example.lesson44pratice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.lesson44pratice.R


class FragmentItemDetails : Fragment() {
    lateinit var iv_detail_icon: ImageView
    lateinit var tv_detail_name: TextView
    lateinit var tv_detail_creator: TextView
    lateinit var tv_detail_description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false)
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