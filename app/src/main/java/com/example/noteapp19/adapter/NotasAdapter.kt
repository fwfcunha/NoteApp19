package com.example.noteapp19.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp19.R
import com.example.noteapp19.model.Nota

import kotlinx.android.synthetic.main.nota_lista.view.*


class NotasAdapter(

) : RecyclerView.Adapter<NotasAdapter.ViewHolder>() {
    //Método que recebe o ViewHolder e a posição da lista.
    //Aqui é recuperado o objeto da lista de Objetos pela posição e associado à
    //ViewHolder.

    private lateinit var clickListener : (Nota) -> Unit
    private var nota: List<Nota> = listOf()


    fun setItems(nota: List<Nota>) {
        this.nota = nota
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nota = notas[position]
        holder.bindView(nota, listener)
    }
    //Método que deverá retornar layout criado pelo ViewHolder já inflado em uma
    //view.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.nota_lista, parent,
            false)
        return ViewHolder(view)
    }
    //Método que deverá retornar quantos itens há na lista.
    override fun getItemCount(): Int {
        return notas.size
    }
    /*
    Com o ViewHolder iremos relacionar o layout criado e adicionar os valores a
   ele*/
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(
            nota: Nota,
            listener: (Nota) -> Unit
        ) = with(itemView) {

            tvNome.text = nota.titulo
            tvDescricao.text = nota.descricao
            setOnClickListener { listener(nota) }
        }
    }
}