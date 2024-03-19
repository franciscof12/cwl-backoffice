package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class BlockedSource(
    val country: String,
    val vertical: Int,
    val sources: Int,
)

object BlockedSources : Table("tbl_blocked_sources") {
    val fkCountry = varchar("fk_c_id_tbl_countries", 2).references(Countries.id)
    val fkVertical = integer("fk_i_id_tbl_vertical").references(Verticals.id)
    val fkSource = integer("fk_i_id_tbl_sources").references(Sources.id)
}
