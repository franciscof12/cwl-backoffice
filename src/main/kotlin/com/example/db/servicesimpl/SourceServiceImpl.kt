package com.example.db.servicesimpl

import com.example.db.services.SourceService
import com.example.models.Source
import com.example.models.Sources
import com.example.plugins.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class SourceServiceImpl : SourceService {
    private fun resultRowToSource(row: ResultRow): Source {
        return Source(
            iIdL = row[Sources.id],
            fkCIdTblCountries = row[Sources.country],
            fkIIdTblVertical = row[Sources.vertical],
            fkIidTblParserTypes = row[Sources.parsertype],
            bActive = row[Sources.active],
        )
    }

    override suspend fun addSource(source: Source): Source =
        dbQuery {
            TODO("Not yet implemented")
        }

    override suspend fun getAllSources(): List<Source> =
        dbQuery {
            Sources.selectAll().map { resultRowToSource(it) }
        }

    override suspend fun deleteSource(id: String): Boolean =
        dbQuery {
            TODO("Not yet implemented")
        }

    override suspend fun getSource(id: String): Source =
        dbQuery {
            TODO("Not yet implemented")
        }
}
