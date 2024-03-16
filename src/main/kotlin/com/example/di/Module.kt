package com.example.di

import com.example.db.*
import org.koin.dsl.module

val appModule = module {
    single<CountryService> { CountryServiceImpl() }
    single<VerticalService> { VerticalServiceImpl() }
    single<SourceService> { SourceServiceImpl() }
    single<ParserTypeService> { ParserTypeServiceImpl() }
}