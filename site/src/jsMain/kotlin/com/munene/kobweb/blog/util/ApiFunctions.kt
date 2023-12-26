package com.munene.kobweb.blog.util

import com.munene.kobweb.blog.models.User
import com.munene.kobweb.blog.models.UserWithoutPassword
import com.varabyte.kobweb.browser.api
import kotlinx.browser.window
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

suspend fun checkUserExistence(user: User): UserWithoutPassword? {
    return try {
        val result = window.api.tryPost(
            apiPath = "usercheck",
            body = Json.encodeToString(user).encodeToByteArray()
        )
        result?.decodeToString()?.let { Json.decodeFromString(it) }
    } catch (e: Exception) {
//        println("CURRENT_USER")
        println(e.message)
        null
    }
}
