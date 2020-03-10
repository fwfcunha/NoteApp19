package com.example.noteapp19.repository

interface NotaRepository{
    fun notasService(
        onComplete:() -> Unit,
        onError: (Throwable?) -> Unit
    )

}