package com.example.db

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
            cId = row[Countries.id],
            fkCIdTblLanguages = row[Countries.fkCIdTblLanguages],
            fkSCurrencyTblCurrencies = row[Countries.fkSCurrencyTblCurrencies],
            sBillingCurrency = row[Countries.sBillingCurrency],
            sName = row[Countries.sName],
            bIsActive = row[Countries.bIsActive],
            bIsSandboxActive = row[Countries.bIsSandboxActive],
            sSimilarNames = row[Countries.sSimilarNames],
        )
    }

    override suspend fun addCountry(country: Country): Country? =
        dbQuery {
            val insertStmt =
                Countries.insert {
                    it[id] = country.cId
                    it[fkCIdTblLanguages] = country.fkCIdTblLanguages
                    it[fkSCurrencyTblCurrencies] = country.fkSCurrencyTblCurrencies
                    it[sBillingCurrency] = country.sBillingCurrency
                    it[sName] = country.sName
                    it[bIsActive] = country.bIsActive
                    it[bIsSandboxActive] = country.bIsSandboxActive
                    it[sSimilarNames] = country.sSimilarNames
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
