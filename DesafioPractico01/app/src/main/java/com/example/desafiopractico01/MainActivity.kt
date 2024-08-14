package com.example.desafiopractico01

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etStudentName = findViewById<EditText>(R.id.et_student_name)
        val etNota1 = findViewById<EditText>(R.id.et_nota1)
        val etNota2 = findViewById<EditText>(R.id.et_nota2)
        val etNota3 = findViewById<EditText>(R.id.et_nota3)
        val etNota4 = findViewById<EditText>(R.id.et_nota4)
        val etNota5 = findViewById<EditText>(R.id.et_nota5)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val cardViewResult = findViewById<CardView>(R.id.card_view_result)

        btnCalculate.setOnClickListener {
            val name = etStudentName.text.toString()
            val nota1 = etNota1.text.toString().toFloatOrNull()
            val nota2 = etNota2.text.toString().toFloatOrNull()
            val nota3 = etNota3.text.toString().toFloatOrNull()
            val nota4 = etNota4.text.toString().toFloatOrNull()
            val nota5 = etNota5.text.toString().toFloatOrNull()

            if (nota1 == null || nota2 == null || nota3 == null || nota4 == null || nota5 == null || name.isEmpty()) {
                Toast.makeText(this, "Ingrese todas las notas y/o el nombre", Toast.LENGTH_SHORT).show()
                cardViewResult.visibility = CardView.GONE
                return@setOnClickListener
            }

            if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 || nota3 < 0 || nota3 > 10 || nota4 < 0 || nota4 > 10 || nota5 < 0 || nota5 > 10) {
                Toast.makeText(this, "Las notas deben estar entre 0 y 10", Toast.LENGTH_SHORT).show()
                cardViewResult.visibility = CardView.GONE
                return@setOnClickListener
            }

            val average = (nota1 * 0.15 + nota2 * 0.15 + nota3 * 0.20 + nota4 * 0.25 + nota5 * 0.25).toFloat()

            val result = if (average >= 6.0) {
                "Aprobado"
            } else {
                "Reprobado"
            }

            tvResult.text = "Estudiante: $name\nPromedio: $average\nResultado: $result"
            cardViewResult.visibility = CardView.VISIBLE
        }
    }
}
