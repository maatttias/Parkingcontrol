
package com.example.parkingcontrol

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProyectoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_proyecto)

        // Identificar los botones del menú
        val botonSensores = findViewById<Button>(
            R.id.btnVerSensores
        )

        val botonControl = findViewById<Button>(
            R.id.btnControlActuadores
        )

        // Navegación a monitoreo de sensores
        botonSensores.setOnClickListener {

            val intent = Intent(
                this@ProyectoActivity,
                SensoresActivity::class.java
            )

            startActivity(intent)
        }

        // Navegación a control de actuadores
        botonControl.setOnClickListener {

            val intent = Intent(
                this@ProyectoActivity,
                ControlActivity::class.java
            )

            startActivity(intent)
        }

        // Ajustar la pantalla a las barras del sistema
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
