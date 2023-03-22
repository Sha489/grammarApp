package com.app.grammarapp.api.model

class English {
    val id: String ?= null
    val _object: String ?= null
    val created: Int ?= null
    val model: String ?= null
    var choices: ArrayList<Choices> = java.util.ArrayList()

    class Choices(
        val text: String,
        val index: Int,
        val logprobs: String,
        val finish_reason: String
    )
}