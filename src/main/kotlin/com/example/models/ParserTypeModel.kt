package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class ParserType(val iId: Int, val sName: String)

object ParserTypes : Table("tbl_parser_types") {
    val id = integer("i_id").autoIncrement().uniqueIndex()
    val sName = varchar("s_name", 255)

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)
}
