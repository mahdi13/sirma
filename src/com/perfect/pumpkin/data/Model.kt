package com.perfect.pumpkin.data

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IdTable
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.dao.UUIDTable
import org.jetbrains.exposed.sql.Column


val ALL_MODELS = arrayOf(
    UserTable,
    MarketTable,
    TikTable
)

object UserTable : UUIDTable("users") {
    var email = varchar("email", 100)
    var password = varchar("password", 64)
}

object MarketTable : IdTable<String>("markets") {
    override var id: Column<EntityID<String>> = varchar("id", 11).primaryKey().entityId()
}

class MarketEntity(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, MarketEntity>(MarketTable)
}

object TikTable : LongIdTable("tiks") {
    var price = long("price")
}