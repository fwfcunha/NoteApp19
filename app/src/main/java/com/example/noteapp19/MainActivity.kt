package com.example.noteapp19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp19.adapter.NotasAdapter
import com.example.noteapp19.model.Nota
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMinhasNotas.adapter = NotasAdapter(carregaNotas(), this) {
            Log.i("TAG", "MEU ITEM")
        }

        val layoutManager = LinearLayoutManager(this)
        rvMinhasNotas.layoutManager = layoutManager
    }
    private fun carregaNotas(): List<Nota> {
        return listOf(
            Nota(
                "Piva",
                "0"))
    }
}
