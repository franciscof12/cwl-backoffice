package com.example.plugins

import com.example.db.*
import com.example.routes.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get

fun Application.configureRouting(
    countryService: CountryService = get(),
    verticalService: VerticalService = get(),
    sourceService: SourceService = get(),
    parserTypeService: ParserTypeService = get(),
    sourceContentService: SourceContentService = get(),
) {
    routing {
        get("/") { call.respond(HttpStatusCode.OK, "Healty") }
        countryRoute(countryService)
        verticalRoute(verticalService)
        sourceRoute(sourceService)
        parserTypeRoute(parserTypeService)
        sourceContentRoute(sourceContentService)
    }
}
