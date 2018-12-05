package data

import io.ktor.config.ApplicationConfig
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

object DatabaseHelper {


    fun init(config: ApplicationConfig, dropIfExists: Boolean = true) {
        connectToDatabase(config)

        transaction {
            if (dropIfExists) {
                deleteSchema()
                flushCache()
            }

            createSchema()
            flushCache()

            insertBaseData()
            commit()
        }

    }

    fun createSchema() {
        SchemaUtils.create(*ALL_MODELS)
    }

    fun deleteSchema() {
        SchemaUtils.drop(*ALL_MODELS)
    }

    fun connectToDatabase(config: ApplicationConfig) {
        val database = Database.connect(
            "jdbc:postgresql://${config.property("host").getString()}:${config.property("port").getString()}/${config.property(
                "name"
            ).getString()}",
            driver = "org.postgresql.Driver",
            user = config.property("username").getString(),
            password = config.property("password").getString(),
            setupConnection = { connection: Connection -> connection.autoCommit = false; }
        )
    }


}