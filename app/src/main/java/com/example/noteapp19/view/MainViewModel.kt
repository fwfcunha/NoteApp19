package com.example.noteapp19.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapp19.model.Nota
import com.example.noteapp19.repository.NotaRepository

class MainViewModel (NotaRepository: NotaRepository) : ViewModel() {

val viewState:MutableLiveData<List<Nota>> = MutableLiveData()

fun nota(){
    viewState.value = viewState.Loading

    notaReposit


    )


}



}