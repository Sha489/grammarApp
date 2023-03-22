package com.app.grammarapp.api

object Endpoints {

    const val BASE_URL = "https://api.openai.com/"

    object Apis {
        const val COMPLETIONS = "v1/completions"
    }

    object Params {
        const val SUCCESS = "success"
        const val MESSAGE = "message"
    }
}