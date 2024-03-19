package com.example.routes

import com.example.db.services.BlockedSourceService
import com.example.models.BlockedSource
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route

fun Routing.sourceContentRoute(blockedSourceService: BlockedSourceService) {
    route("/blockedsources") {
        get {
            val blockedSources = blockedSourceService.getAllBlockedSources()
            if (blockedSources.isEmpty()) {
                call.respond(HttpStatusCode.NotFound, "No blocked sources found")
            } else {
                call.respond(HttpStatusCode.OK, blockedSources)
            }
        }
        post {
            val blockedSource = call.receive<BlockedSource>()
            val added = blockedSourceService.addBlockedSources(blockedSource)
            if (added != null) {
                call.respond(HttpStatusCode.Created, added)
            } else {
                call.respond(HttpStatusCode.NotFound, "No blocked sources found")
            }
        }

        route("/{country?}/{vertical?}/{source?}") {
            get {
                val country = call.parameters["country"] ?: ""
                val vertical = call.parameters["vertical"]?.toInt() ?: 0
                val source = call.parameters["source"]?.toInt() ?: 0
                val blockedSources = blockedSourceService.getBlockedSources(country, vertical, source)

                if (blockedSources.isEmpty()) {
                    call.respond(HttpStatusCode.NotFound, "No sources found")
                } else {
                    call.respond(HttpStatusCode.OK, blockedSources)
                }
            }
            delete {
                val country = call.parameters["country"] ?: ""
                val vertical = call.parameters["vertical"]?.toInt() ?: 0
                val source = call.parameters["source"]?.toInt() ?: 0
                val deleted = blockedSourceService.deleteBlockedSources(country, vertical, source)
                call.respond(HttpStatusCode.OK, deleted)
            }
        }
    }
}
