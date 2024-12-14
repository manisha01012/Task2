package com.example.taskk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding

    val countries = arrayOf("Nepal", "India", "USA", "UK", "Australia", "Germany")

    val cities = arrayOf("Kathmandu", "Butwal", "Bhaktapur", "Kritipur", "Bandipur", "Lalitpur", "Syangja")

    var fullName : String = ""
    var email : String = ""
    var password : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val fullName : String = binding.fullName.editText.toString()
            val email : String = binding.email.editText.toString()
            val password : String = binding.password.editText.toString()

        }

        val autoAdapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_dropdown_item_1line,cities
        )
        binding.autoCompleteTextView.setAdapter(autoAdapter)
        binding.autoCompleteTextView.threshold = 1

        val adapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_dropdown_item,cities
        )

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = this

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.button.visibility = View.VISIBLE
            } else {
                binding.button.visibility = View.GONE
                var intent = Intent(this@MainActivity, DestinationActivity::class.java)
                intent.putExtra("fullName", fullName)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                intent.putExtra("country", countries)
                intent.putExtra("city", cities)
                startActivity(intent)
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?){

       }
    }
