package com.example.db
import com.example.models.ParserType

interface ParserTypeService {
    suspend fun addParserType(parserType: ParserType): ParserType?

    suspend fun getAllParserTypes(): List<ParserType>

    suspend fun deleteParserType(id: String): Boolean

    suspend fun getParserType(id: String): ParserType?
}
