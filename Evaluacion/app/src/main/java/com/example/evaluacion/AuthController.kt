package com.example.evaluacion

import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.lang.Exception

class AuthController(private val authModel: AuthModel, private val context: Context) {

    fun realizarAutenticacion(usuario: String, contrasena: String) {
        try {
            val autenticado = authModel.autenticar(usuario, contrasena)
            if (autenticado) {
                // Lógica después de la autenticación exitosa
                Toast.makeText(context, "Autenticación exitosa", Toast.LENGTH_SHORT).show()

                // Lanzar la actividad Fondo después de una autenticación exitosa
                val intent = Intent(context, Fondo::class.java)
                context.startActivity(intent)
            } else {
                mostrarMensajeError("Error de autenticación")
            }
        } catch (e: AuthenticationException) {
            mostrarMensajeError("Error de autenticación: ${e.message}")
        } catch (e: Exception) {
            mostrarMensajeError("Se produjo un error inesperado: ${e.message}")
        }
    }

    private fun mostrarMensajeError(mensaje: String) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }
}
