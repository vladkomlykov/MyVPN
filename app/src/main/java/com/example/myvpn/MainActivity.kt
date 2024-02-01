package com.example.myvpn

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.random.Random


class MainActivity : ComponentActivity() {

    private lateinit var connect: Button
    private lateinit var layout: LinearLayout
    private lateinit var county: TextView
    private lateinit var ipAdress: TextView
    private lateinit var countryFlag: ImageView
    val countries = ArrayList<String>()
    val ipAdesses = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.mainLayout)
        connect = findViewById(R.id.connect)
        county = findViewById(R.id.countyName)
        ipAdress = findViewById(R.id.ip)
        countryFlag = findViewById(R.id.countryImg)

        connect.setOnClickListener {
            if (connect.text == "Connect") {
                county.visibility = View.VISIBLE
                ipAdress.visibility = View.VISIBLE
                countryFlag.visibility = ImageView.VISIBLE
                selectRandom()

                connect.text = "Disconnect"

                val newButtonColor = Color.parseColor("#9b59b6")
                connect.setBackgroundColor(newButtonColor)

                val newMainColor = Color.parseColor("#FF000000")
                layout.setBackgroundColor(newMainColor)
            } else if (connect.text == "Disconnect") {
                county.visibility = View.INVISIBLE
                ipAdress.visibility = View.INVISIBLE
                countryFlag.visibility = ImageView.INVISIBLE
                connect.text = "Connect"

                val newButtonColor = Color.parseColor("#f4e3cb")
                connect.setBackgroundColor(newButtonColor)

                val newMainColor = Color.parseColor("#3eb489")
                layout.setBackgroundColor(newMainColor)
            }

        }
    }

    private fun fillArray() {
        countries.add("United States")
        countries.add("United Kingdom")
        countries.add("Canada")
        countries.add("Australia")
        countries.add("Germany")

        ipAdesses.add("147.182.180.242")
        ipAdesses.add("134.213.201.140")
        ipAdesses.add("100.42.23.255")
        ipAdesses.add("101.167.175.255")
        ipAdesses.add("104.21.191.255")
    }

    private fun selectRandom() {
        fillArray()
        val randomIndexCountry = Random.nextInt(countries.size)
        val randomCountry = countries[randomIndexCountry]

        county.text = randomCountry

        val randomIndexIp = Random.nextInt(ipAdesses.size)
        val randomIp = ipAdesses[randomIndexIp]

        ipAdress.text = randomIp

        when (randomCountry) {
            "United States" -> {
                countryFlag.setImageResource(R.drawable.usa)
                ipAdress.text = ipAdesses[0]
            }

            "United Kingdom" -> {
                countryFlag.setImageResource(R.drawable.uk)
                ipAdress.text = ipAdesses[1]
            }

            "Canada" -> {
                countryFlag.setImageResource(R.drawable.canada)
                ipAdress.text = ipAdesses[3]
            }

            "Australia" -> {
                countryFlag.setImageResource(R.drawable.australia)
                ipAdress.text = ipAdesses[4]
            }

            "Germany" -> {
                countryFlag.setImageResource(R.drawable.germany)
                ipAdress.text = ipAdesses[5]
            }
        }
    }
}