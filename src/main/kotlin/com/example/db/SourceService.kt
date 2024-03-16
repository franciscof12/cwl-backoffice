package com.example.db

import com.example.models.Source

interface SourceService {
    suspend fun addSource(source: Source): Source?

    suspend fun getAllSources(): List<Source>

    suspend fun deleteSource(id: String): Boolean

    suspend fun getSource(id: String): Source?
}
