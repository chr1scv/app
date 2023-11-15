package com.example.evaluacion

class AuthModel {

    // Utiliza la anotación @Throws para indicar que esta función puede lanzar AuthenticationException
    @Throws(AuthenticationException::class)
    fun autenticar(usuario: String, contrasena: String): Boolean {
        // Implementa la lógica de autenticación real aquí
        // Por ejemplo, puedes comparar con datos almacenados en algún lugar seguro

        // Este es solo un ejemplo básico de lógica de autenticación
        if (usuario == "usuarioEjemplo" && contrasena == "contrasenaEjemplo") {
            return true
        } else {
            // Lanza una excepción en caso de autenticación fallida
            throw AuthenticationException("Credenciales inválidas")
        }
    }
}