package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Vertical(val iId: Int, val sName: String, val fksIIdTblFile: Int?)

object Verticals : Table("tbl_vertical") {
    val id = integer("i_id").autoIncrement().uniqueIndex()
    val sName = varchar("s_name", 255)
    val fksIIdTblFile = integer("fks_i_id_tbl_file").nullable()

    // .references(Files.id, onDelete = ReferenceOption.CASCADE)
    // TODO: Create a table for Files
    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)
}
