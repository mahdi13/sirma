package com.perfect

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.sessions.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.config.ApplicationConfig
import io.ktor.jackson.*
import io.ktor.features.*
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


fun initDatabase(config: ApplicationConfig) {
    Database.connect(
        "jdbc:postgresql://${config.property("host").toString()}:${config.property("port")}/${config.property("name").toString()}\n",
        driver = "org.postgresql.Driver",
        user = config.property("username").toString(),
        password = config.property("password").toString()
    )
}

@kotlin.jvm.JvmOverloads
fun Application.main(testing: Boolean = false) {


    // This adds automatically Date and Server headers to each response, and would allow you to configure
    // additional headers served to each response.
    install(DefaultHeaders)

    // Automatic '304 Not Modified' Responses
    install(ConditionalHeaders)


    install(Sessions) {
        cookie<MySession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
        }
    }

    install(Authentication) {
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    initDatabase(environment.config.config("database"))

    routing {
        get("/") {
            call.respondText(
                environment.config.property("ktor.deployment.port")?.getString() ?: "an",
                contentType = ContentType.Text.Plain
            )
        }

        get("/session/increment") {
            val session = call.sessions.get<MySession>() ?: MySession()
            call.sessions.set(session.copy(count = session.count + 1))
            call.respondText("Counter is ${session.count}. Refresh to increment.")
        }

        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

data class MySession(val count: Int = 0)

