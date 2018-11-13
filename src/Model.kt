package com.perfect

import org.jetbrains.exposed.dao.UUIDTable
import org.jetbrains.exposed.sql.*

object Users : UUIDTable() {
    var email = varchar("email", 100)
    var password = varchar("password", 64)
}