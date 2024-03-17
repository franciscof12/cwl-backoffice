package com.example.db.servicesimpl

import com.example.db.services.SourceContentService
import com.example.models.SourceContent
import com.example.models.SourcesContent
import com.example.plugins.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update

class SourceContentServiceImpl : SourceContentService {
    private fun resultRowToSourceContent(row: ResultRow): SourceContent {
        return SourceContent(
            country = row[SourcesContent.fkCountry],
            source = row[SourcesContent.fkSource],
            vertical = row[SourcesContent.fkVertical],
            crawlingType = row[SourcesContent.crawlingType],
            writesHDFS = row[SourcesContent.writesHDFS] ?: false,
        )
    }

    override suspend fun getAllSourcesContent(): List<SourceContent> =
        dbQuery {
            SourcesContent.selectAll().map { resultRowToSourceContent(it) }
        }

    override suspend fun getSourcesContent(
        country: String,
        vertical: Int,
        source: Int,
    ): List<SourceContent> =
        dbQuery {
            SourcesContent.select {
                (SourcesContent.fkCountry eq country) and
                    (SourcesContent.fkVertical eq vertical) and
                    (SourcesContent.fkSource eq source)
            }.map { resultRowToSourceContent(it) }
        }

    override suspend fun updateSourceContent(sourceContent: SourceContent): Int =
        dbQuery {
            SourcesContent.update({
                (SourcesContent.fkCountry eq sourceContent.country) and
                    (SourcesContent.fkVertical eq sourceContent.vertical) and
                    (SourcesContent.fkSource eq sourceContent.source)
            }) {
                it[crawlingType] = sourceContent.crawlingType
                it[writesHDFS] = sourceContent.writesHDFS
            }
        }

    override suspend fun addSourceContent(sourceContent: SourceContent): SourceContent? =
        dbQuery {
            val insertSourceContent =
                SourcesContent.insert {
                    it[fkCountry] = sourceContent.country
                    it[fkSource] = sourceContent.source
                    it[fkVertical] = sourceContent.vertical
                    it[crawlingType] = sourceContent.crawlingType
                    it[writesHDFS] = sourceContent.writesHDFS
                }
            insertSourceContent.resultedValues?.singleOrNull()?.let { resultRowToSourceContent(it) }
        }
}
