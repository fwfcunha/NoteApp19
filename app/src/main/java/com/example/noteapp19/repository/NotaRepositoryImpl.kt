package com.example.noteapp19.repository

import com.example.noteapp19.api.NotasService
import com.example.noteapp19.model.Nota
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotaRepositoryImpl(var NotasService: NotasService) :
    NotaRepository {
    override fun notasService(onComplete: () -> Unit, onError: (Throwable?) -> Unit) {
        NotasService.nota()
            .enqueue(object : Callback<Nota> {
                override fun onFailure(call: Call<Nota>, t: Throwable) {
                    onError(t)
                }
                override fun onResponse(call: Call<Nota>, response:
                Response<Nota>
                ) {
                    onComplete()
                }
            })
    }
}
