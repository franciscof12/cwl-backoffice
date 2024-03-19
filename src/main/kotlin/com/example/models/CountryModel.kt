package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Country(
    val id: String,
    val sName: String,
    val active: Boolean,
    val sbxactive: Boolean?,
    val similarNames: String?,
)

object Countries : Table("tbl_countries") {
    val id = varchar("c_id", 255).uniqueIndex()
    val sName = varchar("s_name", 255)
    val bIsActive = bool("b_is_active").default(false)
    val bIsSandboxActive = bool("b_is_sandbox_active").nullable()
    val sSimilarNames = text("s_similar_names").nullable()

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)
}
