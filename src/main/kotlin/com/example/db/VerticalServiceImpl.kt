package com.example.db

import com.example.models.Countries
import com.example.models.Country
import org.jetbrains.exposed.sql.*
import com.example.plugins.dbQuery
import com.example.models.Vertical
import com.example.models.Verticals


class VerticalServiceImpl : VerticalService {
    private fun resultRowToVertical(row: ResultRow): Vertical {
        return Vertical(
            iId = row[Verticals.id],
            sName = row[Verticals.sName],
            fksIIdTblFile = row[Verticals.fksIIdTblFile]
        )
    }

    override suspend fun getAllVerticals(): List<Vertical> = dbQuery {
        Verticals.selectAll().map { resultRowToVertical(it) }
    }

    override suspend fun addVertical(vertical: Vertical): Vertical? = dbQuery {
        TODO("Implementar mas adelante..")
    }

    override suspend fun deleteVertical(id: String): Boolean = dbQuery {
        TODO("Implementar mas adelante..")
    }

    override suspend fun getVertical(id: String): Vertical = dbQuery {
        TODO("Implementar mas adelante..")
    }
}