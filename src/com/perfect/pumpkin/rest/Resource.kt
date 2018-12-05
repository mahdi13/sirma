package com.perfect

import io.ktor.locations.Location


data class Error(val title: String = "", val message: String = "")

data class LastLogin(val date: String, val ip: String)
//data class SessionData(val date: String, val ip, val agent, val location: String)
//
//@Location("/users/{email}")
//data class UserAccount(val email: String, val lastLogin: LastLogin)


data class Market(
    val code: String,
    val title: String,
    val capacity: Int,
    val volume: Int,
    val overview: Collection<Point>,
    val report24: PriceReport
)

data class Point(
    val x: Int,
    val y: Int
)

data class PriceReport(
    val fromTime: Long,
    val toTime: Long,
    val highest: Int,
    val lowest: Int,
    val first: Int,
    val last: Int
)


