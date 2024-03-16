package com.example.routes


import com.example.db.SourceContentService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Routing.sourceContentRoute(sourceContentService: SourceContentService){
    route("/sourcecontent"){
        get {
            val sourcescontent = sourceContentService.getAllSourcesContent()
            if (sourcescontent.isEmpty()){
                call.respond(HttpStatusCode.NotFound, "No sources found")
            } else {
                call.respond(HttpStatusCode.OK, sourcescontent)
            }
        }
    }
}