package com.example.chucknorrisfact


import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

object JokeList {
    val jokeList : List<Joke> = listOf<Joke>(
        Json(JsonConfiguration.Stable).parse(Joke.serializer(), """{"categories":[],"created_at":"2020-01-05 13:42:25.099703","icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png","id":"uIdfHDkoSyCerHte9kgcqA","updated_at":"2020-01-05 13:42:25.099703","url":"https://api.chucknorris.io/jokes/uIdfHDkoSyCerHte9kgcqA","value":"Chuck Norris can blow up a balloon with both of his lips tied behind his back."}""")
        ,
        Json(JsonConfiguration.Stable).parse(Joke.serializer(), """{"categories":[],"created_at":"2020-01-05 13:42:23.240175","icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png","id":"yNualoRcRYukITzU-yleow","updated_at":"2020-01-05 13:42:23.240175","url":"https://api.chucknorris.io/jokes/yNualoRcRYukITzU-yleow","value":"Chuck Norris makes great charcoal grilled cannibal kabobs."}""")

       ,
        Json(JsonConfiguration.Stable).parse(Joke.serializer(), """{"categories":[],"created_at":"2020-01-05 13:42:29.569033","icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png","id":"Tk5GzQ81RxyDoq1C0dJJXg","updated_at":"2020-01-05 13:42:29.569033","url":"https://api.chucknorris.io/jokes/Tk5GzQ81RxyDoq1C0dJJXg","value":"A grizzly bear shattered all its teeth when it bit Chuck Norris in the ass. A merciful Chuck Norris then lovingless fed the toothless grizzly 3 gallons of prueed salmon before ripping its gallbladder out through its asshole."}""")

        ,
        Json(JsonConfiguration.Stable).parse(Joke.serializer(), """{"categories":[],"created_at":"2020-01-05 13:42:23.880601","icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png","id":"sH0nsqPTSlqTOgCN2C5qMQ","updated_at":"2020-01-05 13:42:23.880601","url":"https://api.chucknorris.io/jokes/sH0nsqPTSlqTOgCN2C5qMQ","value":"CHuck Norris spilled some milk. He didn't cry over the spilt milk. The spilt milk cried and made its way back into the carton."}""")

        ,
        Json(JsonConfiguration.Stable).parse(Joke.serializer(), """{"categories":[],"created_at":"2020-01-05 13:42:28.143137","icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png","id":"f3cBaAByRWaeKNggFJRivQ","updated_at":"2020-01-05 13:42:28.143137","url":"https://api.chucknorris.io/jokes/f3cBaAByRWaeKNggFJRivQ","value":"It is possible to contract hepatitis from smelling one of Chuck Norris's farts."}""")

        ,
        Json(JsonConfiguration.Stable).parse(Joke.serializer(), """{"categories":[],"created_at":"2020-01-05 13:42:25.099703","icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png","id":"h3Olx9rESdO0OluGQzKqaw","updated_at":"2020-01-05 13:42:25.099703","url":"https://api.chucknorris.io/jokes/h3Olx9rESdO0OluGQzKqaw","value":"On the day before the first day, Chuck Norris said, \"Let there be God.\""}""")

        ,
        Json(JsonConfiguration.Stable).parse(Joke.serializer(), """{"categories":[],"created_at":"2020-01-05 13:42:20.262289","icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png","id":"8fNvcQKqQaiwDDFrC4-wXA","updated_at":"2020-01-05 13:42:20.262289","url":"https://api.chucknorris.io/jokes/8fNvcQKqQaiwDDFrC4-wXA","value":"Before the Boogyman goes to bed at night, he checks in his closet for Chuck Norris."}""")

        )

}