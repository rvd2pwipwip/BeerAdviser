package com.hdesrosiers.beeradviser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_title, container, false)
        val startButton = view.findViewById<Button>(R.id.start_button)

        startButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_titleFragment_to_chooseTypeFragment)
        }

        return view
    }

}