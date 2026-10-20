
package com.example.parkingcontrol

import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Obtener los elementos de la interfaz
        val campoUsuario = findViewById<EditText>(
            R.id.etUsuario
        )

        val campoContrasena = findViewById<EditText>(
            R.id.etContrasena
        )

        val botonIngresar = findViewById<Button>(
            R.id.btnIngresar
        )

        val mensaje = findViewById<TextView>(
            R.id.tvMensaje
        )

        // Validar el inicio de sesión
        botonIngresar.setOnClickListener {

            val usuario = campoUsuario.text.toString().trim()
            val contrasena = campoContrasena.text.toString()

            when {

                // Verificar campos vacíos
                usuario.isEmpty() || contrasena.isEmpty() -> {
                    mensaje.text = "Completa todos los campos"
                    mensaje.setTextColor(Color.RED)
                }

                // Validar las credenciales locales
                usuario == "admin" && contrasena == "1234" -> {

                    mensaje.visibility = View.GONE

                    // Abrir la descripción del proyecto
                    val intent = Intent(
                        this@LoginActivity,
                        ProyectoActivity::class.java
                    )

                    startActivity(intent)

                    // Cerrar la pantalla de login anterior
                    finish()

                    return@setOnClickListener
                }

                // Credenciales incorrectas
                else -> {
                    mensaje.text =
                        "Usuario o contraseña incorrectos"

                    mensaje.setTextColor(Color.RED)
                }
            }

            // Mostrar los mensajes de validación
            mensaje.visibility = View.VISIBLE
        }

        // Ajustar la interfaz a las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->

            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }
}
