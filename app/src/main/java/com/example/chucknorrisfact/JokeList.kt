package com.example.chucknorrisfact


import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

object JokeList {
    val jokeList : List<Joke> = listOf<Joke>(
        Json(JsonConfiguration.Stable).parse(Joke.serializer(), """{"categories":[],"created_at":"2020-01-05 13:42:25.099703","icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png","id":"uIdfHDkoSyCerHte9kgcqA","updated_at":"2020-01-05 13:42:25.099703","url":"https://api.chucknorris.io/jokes/uIdfHDkoSyCerHte9kgcqA","value":"Chuck Norris can blow up a balloon with both of his lips tied behind his back."}"""))


}