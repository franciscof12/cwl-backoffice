package com.example.db

import org.jetbrains.exposed.sql.*
import com.example.plugins.dbQuery
import com.example.models.SourceContent
import com.example.models.SourcesContent

class SourceContentServiceImpl : SourceContentService {
    private fun resultRowToSourceContent(row: ResultRow): SourceContent {
        return SourceContent(
            country = row[SourcesContent.fkCountry],
            source = row[SourcesContent.fkSource],
            vertical = row[SourcesContent.fkVertical],
            crawlingType = row[SourcesContent.crawlingType],
            writesHDFS = row[SourcesContent.writesHDFS]
        )
    }

    override suspend fun addSourceContent(source: SourceContent): SourceContent = dbQuery{
        TODO("Not yet implemented")
    }

    override suspend fun getAllSourcesContent(): List<SourceContent> = dbQuery {
        SourcesContent.selectAll().map { resultRowToSourceContent(it) }
    }

    override suspend fun deleteSourceContent(id: String): Boolean = dbQuery{
        TODO("Not yet implemented")
    }

    override suspend fun getSourceContent(id: String): SourceContent = dbQuery {
        TODO("Not yet implemented")
    }
}