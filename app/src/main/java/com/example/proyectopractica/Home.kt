package com.example.proyectopractica

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {
    private lateinit var boton: Button
    private lateinit var saludar: Button
    private lateinit var spinnerOpciones: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        boton = findViewById(R.id.button)
        saludar = findViewById(R.id.saludar)
        spinnerOpciones = findViewById(R.id.opciones)

        val options = listOf("Masculino", "Femenino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOpciones.adapter = adapter


        boton.setOnClickListener {
            retornar()
        }

        saludar.setOnClickListener {
            saludar()
        }
    }

    private fun retornar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun saludar() {

        val nombre = findViewById<EditText>(R.id.nombre)
        val palabra = nombre.text.toString()


        val selectOpcion = spinnerOpciones.selectedItem.toString()

        // Mostrar el mensaje
        Toast.makeText(
            this,
            "Hola, $palabra, Tu género es: $selectOpcion",
            Toast.LENGTH_SHORT
        ).show()
    }
}
