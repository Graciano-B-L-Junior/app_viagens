package com.example.appviagens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appviagens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calcular){
            calcular()
        }
    }
    private fun calcular(){
        try {
            var distance = binding.distancia.text.toString().toFloat()
            var price = binding.preco.text.toString().toFloat()
            var autonomy = binding.autonomia.text.toString().toFloat()
            val totalValue = (distance * price) / autonomy
            binding.displayTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        }catch (exception:java.lang.NumberFormatException){
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT).show()
        }

    }
}