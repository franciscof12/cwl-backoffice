package com.example.di

import com.example.db.CountryService
import com.example.db.CountryServiceImpl
import com.example.db.VerticalService
import com.example.db.VerticalServiceImpl
import org.koin.dsl.module

val appModule = module {
    single<CountryService> { CountryServiceImpl() }
    single<VerticalService> { VerticalServiceImpl() }
}