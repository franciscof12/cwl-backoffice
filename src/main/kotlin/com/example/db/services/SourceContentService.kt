package com.example.db.services

import com.example.models.SourceContent

interface SourceContentService {
    suspend fun getAllSourcesContent(): List<SourceContent>

    suspend fun getSourcesContent(
        country: String,
        vertical: Int,
        source: Int,
    ): List<SourceContent>

    suspend fun updateSourceContent(sourceContent: SourceContent): Int
}
