package com.example.models

// @Serializable
//data class SourceContent(val country: String, val source: Int, val vertical: Int, val crawlingType: String, val writesHDFS: Boolean)
//
//object SourcesContent:Table() {
//    val country = varchar("fk_c_id_tbl_countries", 2).references(Countries.id, onDelete = ReferenceOption.CASCADE)
//    val crawlingType = varchar("s_crawling_type", 10).nullable()
//    val writesHDFS = bool("b_writes_to_hdfs").default(false)
//}