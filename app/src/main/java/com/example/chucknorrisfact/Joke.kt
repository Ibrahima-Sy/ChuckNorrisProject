package com.example.chucknorrisfact

import kotlinx.serialization.SerialInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Joke ( @SerialName("created_at")
            val createdAt: String,
            @SerialName("icon_url")
            val iconUrl: String,
            @SerialName("updated_at")
            val updatedAt: String,
            val url:String,
            val value:String,
            val categories:List<String>,
            val id:String
)



