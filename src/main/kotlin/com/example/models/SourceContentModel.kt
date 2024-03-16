package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class SourceContent(
    val country: String,
    val source: Int,
    val vertical: Int,
    val crawlingType: String?,
    val writesHDFS: Boolean,
)

object SourcesContent : Table("tbl_sources_content") {
    val fkCountry = varchar("fk_c_id_tbl_countries", 255).references(Countries.id)
    val fkSource = integer("fk_i_id_tbl_sources").references(Sources.id)
    val fkVertical = integer("fk_i_id_tbl_vertical").references(Verticals.id)
    val crawlingType = varchar("s_crawling_type", 255).nullable()
    val writesHDFS = bool("b_writes_to_hdfs").nullable()
}
