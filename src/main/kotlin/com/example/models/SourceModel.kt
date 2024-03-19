package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

@Serializable
data class Source(
    val id: Int,
    val country: String,
    val vertical: Int,
    val parserType: Int,
    val active: Boolean,
)

object Sources : Table("tbl_sources") {
    val id = integer("i_id").autoIncrement().uniqueIndex()
    val country = varchar("fk_c_id_tbl_countries", 2).references(Countries.id, onDelete = ReferenceOption.CASCADE)
    val vertical = integer("fk_i_id_tbl_vertical").references(Verticals.id, onDelete = ReferenceOption.CASCADE)
    val parsertype = integer("fk_i_id_tbl_parser_types").references(ParserTypes.id, onDelete = ReferenceOption.CASCADE)

    // TODO: Create a new table for ParserTypes
    val active = bool("b_active")

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)
}
