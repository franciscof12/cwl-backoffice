package com.example.db

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
