package com.perfect

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.sessions.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import com.perfect.sirma.main
import io.ktor.jackson.*
import io.ktor.features.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ main(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("8080", response.content)
            }
        }
    }
}
