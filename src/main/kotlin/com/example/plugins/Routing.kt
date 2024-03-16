package com.example.plugins

import com.example.db.CountryService
import com.example.db.ParserTypeService
import com.example.db.SourceService
import com.example.db.VerticalService
import com.example.routes.countryRoute
import com.example.routes.parserTypeRoute
import com.example.routes.sourceRoute
import com.example.routes.verticalRoute
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get

fun Application.configureRouting( countryService: CountryService=get(), verticalService: VerticalService=get(), sourceService: SourceService=get(), parserTypeService: ParserTypeService=get()) {
    routing {
        get ("/"){ call.respond(HttpStatusCode.OK, "Healty") }
        countryRoute(countryService)
        verticalRoute(verticalService)
        sourceRoute(sourceService)
        parserTypeRoute(parserTypeService)
    }
}
