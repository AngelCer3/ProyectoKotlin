package com.example.proyectopractica

import android.content.Intent
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    private lateinit var boton : Button

    private lateinit var saludar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            boton = findViewById(R.id.button)

            saludar = findViewById(R.id.saludar)

            boton.setOnClickListener{
                retornar()
            }

            saludar.setOnClickListener{
                saludar()
            }
            insets
        }
    }
    private fun retornar(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun saludar(){
        val nombre = findViewById<EditText>(R.id.nombre)
        val palabra = nombre.text.toString()

        val spinnerOpciones = findViewById<Spinner>(R.id.opciones)

        val options = listOf("Masculiino", "Femenino")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOpciones.adapter

        var selectOpcion = ""

        spinnerOpciones.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,view: View?, position: Int, id:Long){
                selectOpcion = options[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        Toast.makeText(this,"Hola, $palabra , Tu genero es: $selectOpcion", Toast.LENGTH_SHORT).show()
    }
}