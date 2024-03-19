package com.example.plugins

import com.example.db.services.BlockedSourceService
import com.example.db.services.CountryService
import com.example.db.services.ParserTypeService
import com.example.db.services.SourceContentService
import com.example.db.services.SourceService
import com.example.db.services.VerticalService
import com.example.routes.countryRoute
import com.example.routes.parserTypeRoute
import com.example.routes.sourceContentRoute
import com.example.routes.sourceRoute
import com.example.routes.verticalRoute
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import org.koin.ktor.ext.get

fun Application.configureRouting(
    countryService: CountryService = get(),
    verticalService: VerticalService = get(),
    sourceService: SourceService = get(),
    parserTypeService: ParserTypeService = get(),
    sourceContentService: SourceContentService = get(),
    blockedSourceService: BlockedSourceService = get(),
) {
    routing {
        get("/") { call.respond(HttpStatusCode.OK, "Healty") }
        countryRoute(countryService)
        verticalRoute(verticalService)
        sourceRoute(sourceService)
        parserTypeRoute(parserTypeService)
        sourceContentRoute(sourceContentService)
        sourceContentRoute(blockedSourceService)
    }
}
