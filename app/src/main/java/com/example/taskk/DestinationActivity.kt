package com.example.taskk

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskk.databinding.ActivityDestinationBinding


class DestinationActivity : AppCompatActivity() {
    lateinit var binding : ActivityDestinationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fullName = intent.getStringExtra("fullName") ?: "N/A"
        val email = intent.getStringExtra("email") ?: "N/A"
        val password = intent.getStringExtra("password") ?: "N/A"
        val country = intent.getStringExtra("country") ?: "N/A"
        val city = intent.getStringExtra("city") ?: "N/A"

        binding.outFullname.text = "Full Name: $fullName"
        binding.outEmail.text = "Email: $email"
        binding.outGender.text = "Gender: "
        binding.outCountry.text = "Country: $country"
        binding.outCity.text = "City: $city"


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
     }
}