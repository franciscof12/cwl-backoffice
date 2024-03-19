package com.example.db.services

import com.example.models.BlockedSource

interface BlockedSourceService {
    suspend fun getAllBlockedSources(): List<BlockedSource>

    suspend fun getBlockedSources(
        country: String,
        vertical: Int,
        source: Int,
    ): List<BlockedSource>

    suspend fun addBlockedSources(sourceContent: BlockedSource): BlockedSource?

    suspend fun deleteBlockedSources(
        country: String,
        vertical: Int,
        source: Int,
    ): String
}
