package com.calculadoracombustivel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val editTextPrecoGasolina = findViewById<EditText>(R.id.gasolinePrice)
        val editTextPrecoEtanol = findViewById<EditText>(R.id.ethanolPrice)
        val buttonCalcular = findViewById<Button>(R.id.calculateButton)
        val buttonLimpar = findViewById<Button>(R.id.cleanButton)
        val textViewResultado = findViewById<TextView>(R.id.resultado)

        buttonCalcular.setOnClickListener {
            val precoGasolina = editTextPrecoGasolina.text.toString().substring(3).toFloatOrNull()
            val precoEtanol = editTextPrecoEtanol.text.toString().substring(3).toFloatOrNull()

            if(precoGasolina != null && precoEtanol != null) {
                val custoBeneficio = precoEtanol / precoGasolina

                val melhorOpcao = if(custoBeneficio < 0.7) {
                    "Etanol"
                } else {
                    "Gasolina"
                }

                textViewResultado.text = "Custo benefício: $custoBeneficio\nMelhor opção: $melhorOpcao"
            } else {
                textViewResultado.text = "Valores inseridos inválidos."
            }
        }

        buttonLimpar.setOnClickListener {
            editTextPrecoGasolina.text.clear()
            editTextPrecoEtanol.text.clear()
            textViewResultado.text = ""
        }
    }
}