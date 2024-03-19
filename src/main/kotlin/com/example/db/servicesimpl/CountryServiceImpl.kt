package com.example.db.servicesimpl

import com.example.db.services.CountryService
import com.example.models.Countries
import com.example.models.Country
import com.example.plugins.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class CountryServiceImpl : CountryService {
    private fun resultRowToCountry(row: ResultRow): Country {
        return Country(
            id = row[Countries.id],
            sName = row[Countries.sName],
            active = row[Countries.bIsActive],
            sbxactive = row[Countries.bIsSandboxActive],
            similarNames = row[Countries.sSimilarNames],
        )
    }

    override suspend fun addCountry(country: Country): Country? =
        dbQuery {
            val insertStmt =
                Countries.insert {
                    it[id] = country.id
                    it[sName] = country.sName
                    it[bIsActive] = country.active
                    it[bIsSandboxActive] = country.sbxactive
                    it[sSimilarNames] = country.similarNames
                }
            insertStmt.resultedValues?.singleOrNull()?.let { resultRowToCountry(it) }
        }

    override suspend fun getAllCountries(): List<Country> =
        dbQuery {
            Countries.selectAll().map { resultRowToCountry(it) }
        }

    override suspend fun deleteCountry(id: String): Boolean =
        dbQuery {
            TODO("Investigar como realizar el delete en Exposed")
        }

    override suspend fun getCountry(id: String): Country? =
        dbQuery {
            Countries.select { Countries.id eq id }.map { resultRowToCountry(it) }.singleOrNull()
        }
}
