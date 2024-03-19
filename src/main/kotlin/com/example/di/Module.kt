package com.example.di

import com.example.db.services.BlockedSourceService
import com.example.db.services.CountryService
import com.example.db.services.ParserTypeService
import com.example.db.services.SourceContentService
import com.example.db.services.SourceService
import com.example.db.services.VerticalService
import com.example.db.servicesimpl.BlockedSourceServiceImpl
import com.example.db.servicesimpl.CountryServiceImpl
import com.example.db.servicesimpl.ParserTypeServiceImpl
import com.example.db.servicesimpl.SourceContentServiceImpl
import com.example.db.servicesimpl.SourceServiceImpl
import com.example.db.servicesimpl.VerticalServiceImpl
import org.koin.dsl.module

val appModule =
    module {
        single<CountryService> { CountryServiceImpl() }
        single<VerticalService> { VerticalServiceImpl() }
        single<SourceService> { SourceServiceImpl() }
        single<ParserTypeService> { ParserTypeServiceImpl() }
        single<SourceContentService> { SourceContentServiceImpl() }
        single<BlockedSourceService> { BlockedSourceServiceImpl() }
    }
