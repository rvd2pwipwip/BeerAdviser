package com.hdesrosiers.beeradviser

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.find_beer_button)
        val beerColorSpinner = findViewById<Spinner>(R.id.beer_color_spinner)
        val brands = findViewById<TextView>(R.id.brands_text_view)

        findBeer.setOnClickListener {
            val color = "${beerColorSpinner.selectedItem}"
//            val doodah = "doodah!"
//            brands.text = getString(R.string.brands_selected, color, doodah)

            val beerList = getBeers(color)
            val beers = beerList.reduce { str, item -> str + '\n' + item }
            brands.text = beers
        }
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
