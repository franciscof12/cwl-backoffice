package com.example.routes


import com.example.db.SourceContentService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.route


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
        get("/{country?}/{vertical?}/{source?}"){
            val country = call.parameters["country"] ?: ""
            val vertical = call.parameters["vertical"]?.toInt() ?: 0
            val source = call.parameters["source"]?.toInt() ?: 0
            val sourcescontent = sourceContentService.getSourcesContent(country, vertical, source)

            if (sourcescontent.isEmpty()){
                call.respond(HttpStatusCode.NotFound, "No sources found")
            } else {
                call.respond(HttpStatusCode.OK, sourcescontent)
            }
        }
    }
}
