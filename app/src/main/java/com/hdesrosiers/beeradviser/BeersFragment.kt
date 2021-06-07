package com.hdesrosiers.beeradviser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BeersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beers, container, false)
        val suggestions = view.findViewById<TextView>(R.id.brands_text_view)
        //retrieve passed argument using navigation safeargs
        val beerType = BeersFragmentArgs.fromBundle(requireArguments()).beerType

        suggestions.text = getBeers(beerType).reduce { acc, c ->  acc + '\n' + c}

        return view
    }

    private fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }

}