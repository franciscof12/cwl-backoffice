package com.example.db

import org.jetbrains.exposed.sql.*
import com.example.plugins.dbQuery
import com.example.models.Source
import com.example.models.Sources


class SourceServiceImpl : SourceService {
    private fun resultRowToVertical(row: ResultRow): Source {
        return Source(
            iIdL = row[Sources.id],
            fkCIdTblCountries = row[Sources.country],
            fkIIdTblVertical = row[Sources.vertical],
            fkIidTblParserTypes = row[Sources.parsertype],
            bActive = row[Sources.active]
        )
    }

    override suspend fun addSource(source: Source): Source = dbQuery{
        TODO("Not yet implemented")
    }

    override suspend fun getAllSources(): List<Source> = dbQuery{
        Sources.selectAll().map { resultRowToVertical(it) }
        TODO("Reparar el error ya que actualmente devuelve un 500 Internal Server Error")
    }

    override suspend fun deleteSource(id: String): Boolean = dbQuery{
        TODO("Not yet implemented")
    }

    override suspend fun getSource(id: String): Source = dbQuery {
        TODO("Not yet implemented")
    }
}