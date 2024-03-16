package com.example.db

import com.example.models.ParserType
import com.example.models.ParserTypes
import org.jetbrains.exposed.sql.*
import com.example.plugins.dbQuery


class ParserTypeServiceImpl : ParserTypeService {
    private fun resultRowToParserType(row: ResultRow): ParserType {
        return ParserType(
            iId = row[ParserTypes.id],
            sName = row[ParserTypes.sName],
        )
    }

    override suspend fun getAllParserTypes(): List<ParserType> = dbQuery {
        ParserTypes.selectAll().map { resultRowToParserType(it) }
    }

    override suspend fun addParserType(vertical: ParserType): ParserType? = dbQuery {
        TODO("Implementar mas adelante..")
    }

    override suspend fun deleteParserType(id: String): Boolean = dbQuery {
        TODO("Implementar mas adelante..")
    }

    override suspend fun getParserType(id: String): ParserType = dbQuery {
        TODO("Implementar mas adelante..")
    }
}