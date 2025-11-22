package com.ibrohimapk3.notest1.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.ibrohimapk3.notest1.R
class InfoAboutItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_info_about_item, container, false)
        var btn_back = view.findViewById<Button>(R.id.btn_back)
        var tv_title = view.findViewById<TextView>(R.id.tv_title)
        var tv_content = view.findViewById<TextView>(R.id.tv_contain)
        val title = arguments?.getString("title")
        val content = arguments?.getString("content")
        btn_back.setOnClickListener {
            findNavController().navigate(R.id.action_infoAboutItemFragment_to_mainFragment)
        }
        tv_title.text = title.toString()
        tv_content.text = content.toString()

        return view
    }
}