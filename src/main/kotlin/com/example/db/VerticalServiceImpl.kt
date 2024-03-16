package com.example.db

import com.example.models.Vertical
import com.example.models.Verticals
import com.example.plugins.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class VerticalServiceImpl : VerticalService {
    private fun resultRowToVertical(row: ResultRow): Vertical {
        return Vertical(
            iId = row[Verticals.id],
            sName = row[Verticals.sName],
            fksIIdTblFile = row[Verticals.fksIIdTblFile],
        )
    }

    override suspend fun getAllVerticals(): List<Vertical> =
        dbQuery {
            Verticals.selectAll().map { resultRowToVertical(it) }
        }

    override suspend fun addVertical(vertical: Vertical): Vertical? =
        dbQuery {
            TODO("Implementar mas adelante..")
        }

    override suspend fun deleteVertical(id: String): Boolean =
        dbQuery {
            TODO("Implementar mas adelante..")
        }

    override suspend fun getVertical(id: String): Vertical =
        dbQuery {
            TODO("Implementar mas adelante..")
        }
}
