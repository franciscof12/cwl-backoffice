package com.example.plugins

import com.example.models.Countries
import com.example.models.ParserTypes
import com.example.models.Sources
import com.example.models.SourcesContent
import com.example.models.Verticals
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

val config: Config = ConfigFactory.load()
val storageConfig: Config = config.getConfig("storage")
val DRIVER_CLASSNAME: String = storageConfig.getString("driverClassName")
val JDBC_URL: String = storageConfig.getString("jdbcUrl")

fun configureDatabases() {
    val db = Database.connect(provideDataSource(JDBC_URL, DRIVER_CLASSNAME))
    transaction(db) {
        SchemaUtils.create(Countries, Verticals, ParserTypes, SourcesContent, Sources)
    }
}

private fun provideDataSource(
    url: String,
    driverClass: String,
): HikariDataSource {
    val hikariConfig =
        HikariConfig().apply {
            driverClassName = driverClass
            jdbcUrl = url
            maximumPoolSize = 3
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
    return HikariDataSource(hikariConfig)
}

suspend fun <T> dbQuery(block: suspend () -> T): T {
    return newSuspendedTransaction(Dispatchers.IO) { block() }
}
