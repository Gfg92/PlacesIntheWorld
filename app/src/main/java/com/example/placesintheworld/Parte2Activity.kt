package com.example.placesintheworld

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.ChipGroup

class Parte2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parte2)

        // Spinner con EditText
        val ejercicios = arrayOf("adventures", "guided visits", "trekking")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, ejercicios)
        val listaEjercicios = findViewById(R.id.spinner) as Spinner


        listaEjercicios.adapter = adaptador
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        val chipGroup: ChipGroup = findViewById(R.id.chipGroup)
        chipGroup.setOnClickListener{
            Toast.makeText(this, "" + chipGroup, Toast.LENGTH_LONG).show()
        }


    }


}