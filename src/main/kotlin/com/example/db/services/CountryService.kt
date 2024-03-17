package com.example.db.services

import com.example.models.Country

interface CountryService {
    suspend fun addCountry(country: Country): Country?

    suspend fun getAllCountries(): List<Country>

    suspend fun deleteCountry(id: String): Boolean

    suspend fun getCountry(id: String): Country?
}
