package com.example.noteapp19.api

import com.example.noteapp19.model.Nota
import retrofit2.Call
import retrofit2.http.GET

interface NotasService {
    @GET("/nota")
    fun nota(): Call<Nota>

}
