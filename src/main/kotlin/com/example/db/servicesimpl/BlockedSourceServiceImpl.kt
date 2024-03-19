package com.example.db.servicesimpl

import com.example.db.services.BlockedSourceService
import com.example.models.BlockedSource
import com.example.models.BlockedSources
import com.example.plugins.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class BlockedSourceServiceImpl : BlockedSourceService {
    private fun resultRowToBlockedSource(row: ResultRow): BlockedSource {
        return BlockedSource(
            country = row[BlockedSources.fkCountry],
            vertical = row[BlockedSources.fkVertical],
            sources = row[BlockedSources.fkSource],
        )
    }

    override suspend fun getAllBlockedSources(): List<BlockedSource> =
        dbQuery {
            BlockedSources.selectAll().map { resultRowToBlockedSource(it) }
        }

    override suspend fun getBlockedSources(
        country: String,
        vertical: Int,
        source: Int,
    ): List<BlockedSource> =
        dbQuery {
            BlockedSources.select {
                (BlockedSources.fkCountry eq country) and
                    (BlockedSources.fkVertical eq vertical) and
                    (BlockedSources.fkSource eq source)
            }.map { resultRowToBlockedSource(it) }
        }

    override suspend fun addBlockedSources(blockedSource: BlockedSource): BlockedSource? =
        dbQuery {
            val insertSourceContent =
                BlockedSources.insert {
                    it[fkCountry] = blockedSource.country
                    it[fkVertical] = blockedSource.vertical
                    it[fkSource] = blockedSource.sources
                }
            insertSourceContent.resultedValues?.singleOrNull()?.let { resultRowToBlockedSource(it) }
        }

    override suspend fun deleteBlockedSources(
        country: String,
        vertical: Int,
        source: Int,
    ): String =
        dbQuery {
            BlockedSources.deleteWhere {
                (fkCountry eq country) and
                    (fkVertical eq vertical) and
                    (fkSource eq source)
            }
            "Blocked source deleted"
        }
}
