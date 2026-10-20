
package com.example.parkingcontrol

import android.os.Bundle
import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ControlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_control)

        // Identificar los botones del XML
        val botonActivar = findViewById<Button>(
            R.id.btnActivar
        )

        val botonDesactivar = findViewById<Button>(
            R.id.btnDesactivar
        )

        val botonEstado = findViewById<Button>(
            R.id.btnEstado
        )

        // Identificar el texto de resultados
        val resultado = findViewById<TextView>(
            R.id.tvResultadoControl
        )

        // Botón para activar el sistema
        botonActivar.setOnClickListener {

            val comando = "ON"

            resultado.text =
                "Comando seleccionado: $comando\n" +
                        "Modo demostración: no se envió a Arduino."

            resultado.setTextColor(
                Color.parseColor("#0D9488")
            )
        }

        // Botón para desactivar el sistema
        botonDesactivar.setOnClickListener {

            val comando = "OFF"

            resultado.text =
                "Comando seleccionado: $comando\n" +
                        "Modo demostración: no se envió a Arduino."

            resultado.setTextColor(
                Color.parseColor("#DC2626")
            )
        }

        // Botón para consultar el estado
        botonEstado.setOnClickListener {

            val comando = "ESTADO"

            resultado.text =
                "Consulta seleccionada: $comando\n" +
                        "Sin conexión Bluetooth. No hay datos reales."

            resultado.setTextColor(
                Color.parseColor("#14283F")
            )
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
