package com.example.storybook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {

    private lateinit var spAnimals: Spinner
    private lateinit var selectedAnimal: String
    private lateinit var etName: EditText
    private lateinit var etReligion: EditText
    private lateinit var etLocation: EditText
    private lateinit var btStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        etName = findViewById(R.id.etName)
        etReligion = findViewById(R.id.etReligion)
        etLocation = findViewById(R.id.etLocation)
        spAnimals = findViewById(R.id.spAnimals)
        spAnimals.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedAnimal = adapterView?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { }
        }
        btStart = findViewById(R.id.btStart)

        btStart.setOnClickListener {
            if (etName.text.toString().isEmpty() || etReligion.text.toString().isEmpty() ||
                    etLocation.text.toString().isEmpty()) {
                Toast.makeText(applicationContext, "თუ არ ჩაწერე არ იმუშავებს", Toast.LENGTH_SHORT).show()
            }
            else {
                intent = Intent(this, MainActivity2::class.java)
                val bundle = bundleOf(
                    Pair("Name", etName.text.toString()),
                    Pair("Religion", etReligion.text.toString()),
                    Pair("Location", etLocation.text.toString()),
                    Pair("Animal", selectedAnimal)
                )
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

    }
}

