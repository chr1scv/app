package com.example.evaluacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eva.AuthController
import com.example.eva.AuthModel
import com.example.eva.AuthenticationException
import com.example.eva.R

class MainActivity : AppCompatActivity() {

    private val authModel = AuthModel()
    private val authController = AuthController(authModel, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)
        val editUser = findViewById<EditText>(R.id.editUser)
        val editPass = findViewById<EditText>(R.id.editPass)

        btnIniciarSesion.setOnClickListener {
            val usuario = editUser.text.toString()
            val contraseña = editPass.text.toString()

            // Manejo de excepciones con try-catch
            try {
                authController.realizarAutenticacion(usuario, contraseña)
            } catch (e: AuthenticationException) {
                mostrarMensajeError("Error de autenticación: ${e.message}")
            } catch (e: Exception) {
                mostrarMensajeError("Se produjo un error inesperado: ${e.message}")
            }
        }
    }

    private fun mostrarMensajeError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
