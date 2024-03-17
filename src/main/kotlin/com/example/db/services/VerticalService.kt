package com.example.db.services

import com.example.models.Vertical

interface VerticalService {
    suspend fun addVertical(vertical: Vertical): Vertical?

    suspend fun getAllVerticals(): List<Vertical>

    suspend fun deleteVertical(id: String): Boolean

    suspend fun getVertical(id: String): Vertical?
}
