package com.example.routes

import com.example.db.services.ParserTypeService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.parserTypeRoute(parserTypeService: ParserTypeService) {
    route("/parsertype") {
        get {
            val verticals = parserTypeService.getAllParserTypes()
            call.respond(HttpStatusCode.OK, verticals)
        }
    }
}
