package com.perfect

import io.ktor.application.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import data.DatabaseHelper
import io.ktor.jackson.*
import io.ktor.features.*
import io.ktor.routing.Routing
import rest.RouteHelper

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


@kotlin.jvm.JvmOverloads
fun Application.main(testing: Boolean = false) {


    // This adds automatically Date and Server headers to each response, and would allow you to configure
    // additional headers served to each response.
    install(DefaultHeaders)

    // Automatic '304 Not Modified' Responses
    install(ConditionalHeaders)

    //JWT authentication
    install(Authentication)

    // Enabling JSON by Jackson
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    install(Routing)

    DatabaseHelper.init(environment.config.config("database"))
    RouteHelper.init(this)

}


