package com.example.db
import com.example.models.SourceContent

interface SourceContentService {
    suspend fun addSourceContent(source: SourceContent):SourceContent?
    suspend fun getAllSourcesContent():List<SourceContent>
    suspend fun deleteSourceContent(id:String):Boolean
    suspend fun getSourceContent(id:String):SourceContent?
}