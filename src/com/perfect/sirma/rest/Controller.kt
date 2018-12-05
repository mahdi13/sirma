package com.perfect.sirma.rest

import com.perfect.Market
import com.perfect.Point
import com.perfect.PriceReport
import com.perfect.sirma.data.Repository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


//get("/") {
//    call.respondText("Request uri: ${call.request.uri}")
//}
//
//
//fun Route.sessions() {
//    get("/") {
//        call.respondText("Request uri: ${call.request.uri}")
//    }
//
//    get
//}
//
//
//object Root{
//
//
//
//
//}


object RouteHelper {
    fun init(application: Application) {
        application.apply {
            routing {

                get("/") {
                    call.respond(mapOf("version" to "0.0.1", "copyright" to "Do not do!"))
                }

                route("/markets") {
                    get("/") {
//                        call.respond(MarketEntity.all())
                        call.respond(Repository.getAllMarkets().map {
                            Market(
                                it.id.toString(),
                                "Crypto Market!",
                                0,
                                0,
                                listOf(Point(0, 0)),
                                PriceReport(0L, 0L, 100, 0, 10, 60)
                            )

                        })
                    }
                }

//                authenticate {
//
//                }


            }
        }


    }
}

//fun initializeRouting(application: Application) {
//    application.apply {
//        routing {
//            get("/") {
//                call.respond(mapOf())
//
//            }
//
//
////            authenticate {
////                get("/session/increment") {
////                    val session = call.sessions.get<MySession>() ?: MySession()
////                    call.sessions.set(session.copy(count = session.count + 1))
////                    call.respondText("Counter is ${session.count}. Refresh to increment.")
////                }
////            }
//
//            get("/json/jackson") {
//                call.respond(mapOf("hello" to "world"))
//            }
//
////            sessions()
//        }
//    }
//}

