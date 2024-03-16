package com.example.plugins

import com.example.models.Countries
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import com.zaxxer.hikari.HikariDataSource
import com.zaxxer.hikari.HikariConfig
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

fun Application.configureDatabases() {
    val url = environment.config.property("ktor.datasource.jdbcUrl").getString()
    val driverClass = environment.config.property("ktor.datasource.driverClassName").getString()
    val dataSource = provideDataSource(url, driverClass)
    Database.connect(dataSource)
    transaction {
        SchemaUtils.create(Countries)
    }
}

private fun provideDataSource(url:String,driverClass:String):HikariDataSource{
    val hikariConfig= HikariConfig().apply {
        driverClassName=driverClass
        jdbcUrl=url
        maximumPoolSize=3
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        validate()
    }
    return HikariDataSource(hikariConfig)
}


suspend fun <T> dbQuery(block:suspend ()->T):T{
    return newSuspendedTransaction(Dispatchers.IO) { block() }
}