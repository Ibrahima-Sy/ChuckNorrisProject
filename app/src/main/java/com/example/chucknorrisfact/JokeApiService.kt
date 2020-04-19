package com.example.chucknorrisfact

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface JokeApiService {

    @GET("https://api.chucknorris.io/jokes/random/")
    fun giveMeAJoke(): Single<Joke>
    @GET("https://api.chucknorris.io/jokes/random/")
    fun giveMe10():Observable<Joke>

}