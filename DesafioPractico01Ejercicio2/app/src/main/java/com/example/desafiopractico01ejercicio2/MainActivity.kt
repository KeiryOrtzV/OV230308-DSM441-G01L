package com.example.desafiopractico01ejercicio2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmployeeName = findViewById<EditText>(R.id.etEmployeeName)
        val etBaseSalary = findViewById<EditText>(R.id.etBaseSalary)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val employeeName = etEmployeeName.text.toString()
            val baseSalary = etBaseSalary.text.toString().toDoubleOrNull()

            if (employeeName.isEmpty() || baseSalary == null || baseSalary <= 0) {
                tvResult.text = "Ingrese un nombre válido y un salario base positivo."
                return@setOnClickListener
            }

            val afp = baseSalary * 0.0725
            val isss = baseSalary * 0.03
            val renta = calculateRenta(baseSalary)
            val salarioNeto = baseSalary - afp - isss - renta

            tvResult.text = """
                Nombre: $employeeName
                Salario Base: $baseSalary
                AFP (7.25%): $afp
                ISSS (3%): $isss
                Renta: $renta
                Salario Neto: $salarioNeto
            """.trimIndent()
        }
    }

    private fun calculateRenta(baseSalary: Double): Double {
        return when {
            baseSalary <= 472.00 -> 0.0
            baseSalary <= 895.24 -> 0.10 * (baseSalary - 472.00) + 17.67
            baseSalary <= 2038.10 -> 0.20 * (baseSalary - 895.24) + 60.00
            else -> 0.30 * (baseSalary - 2038.10) + 288.57
        }
    }
}
