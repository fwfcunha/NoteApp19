package com.example.noteapp19.di

import com.example.noteapp19.adapter.NotasAdapter
import com.example.noteapp19.api.AuthInterceptor
import com.example.noteapp19.api.NotasService
import com.example.noteapp19.repository.NotaRepository
import com.example.noteapp19.repository.NotaRepositoryImpl
import com.example.noteapp19.view.MainViewModel
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val viewModule = module {
    factory { NotasAdapter(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}


val repositoryModule = module {
    single<NotaRepository> { NotaRepositoryImpl(get()) }
}


val networkModule = module {
    single { createNetworkClient(get(), get(named("baseUrl"))).create(NotasService::class.java) }
    single { createOkhttpClientAuth(get()) }
    single<Interceptor> { AuthInterceptor() }
    single(named("baseUrl")) { "https://blocodenotasmeunome.herokuapp.com" }

}

private fun createNetworkClient(okHttpClient: OkHttpClient, baseURL: String): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


private fun createOkhttpClientAuth(authInterceptor: Interceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addNetworkInterceptor(StethoInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
    return builder.build()
}