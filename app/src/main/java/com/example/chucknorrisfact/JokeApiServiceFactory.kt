package com.example.chucknorrisfact

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.create


@UnstableDefault
object JokeApiServiceFactory {


    fun idle1(): JokeApiService{

        val retroBuilder: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/random/")
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return(retroBuilder.create())
    }
}