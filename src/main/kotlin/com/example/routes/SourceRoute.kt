package com.example.routes

import com.example.db.services.SourceService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.sourceRoute(sourceService: SourceService) {
    route("/source") {
        get {
            val sources = sourceService.getAllSources()
            if (sources.isEmpty()) {
                call.respond(HttpStatusCode.NotFound, "No sources found")
            } else {
                call.respond(HttpStatusCode.OK, sources)
            }
        }
    }
}
