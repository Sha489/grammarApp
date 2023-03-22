package com.app.grammarapp.api.model

class QueryParams {
    var model: String ?= null
    var prompt: String ?= null
    var temperature: Int ?= null
    var max_tokens: Int ?= null
    var top_p: Int ?= null
    var frequency_penalty: Int ?= null
    var presence_penalty: Int ?= null
}