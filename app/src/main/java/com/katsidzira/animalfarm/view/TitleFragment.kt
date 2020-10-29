package com.katsidzira.animalfarm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.katsidzira.animalfarm.R

class TitleFragment : Fragment() {
    private lateinit var textview: TextView
    private lateinit var button: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_title, container, false)
        textview = v.findViewById(R.id.textview)
        button = v.findViewById(R.id.button)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }
    }
}