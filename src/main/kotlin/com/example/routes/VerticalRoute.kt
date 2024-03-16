package com.example.routes

import com.example.db.VerticalService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.verticalRoute(verticalService: VerticalService) {
    route("/vertical") {
        get {
            val verticals = verticalService.getAllVerticals()
            call.respond(HttpStatusCode.OK, verticals)
        }
    }
}
