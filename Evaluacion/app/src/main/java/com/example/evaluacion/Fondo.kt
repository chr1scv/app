package com.example.evaluacion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fondo.*

class Fondo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fondo)

        // Configuración del botón de flecha
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Configuración de la barra de navegación
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item2 -> {
                    // Lógica para el segundo elemento del menú (Fondo)
                    true
                }
                R.id.menu_item3 -> {
                    // Lógica para el tercer elemento del menú (Fondo2)
                    startActivity(Intent(this, Fondo2::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
