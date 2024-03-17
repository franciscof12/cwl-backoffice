package com.example.routes

import com.example.db.services.CountryService
import com.example.models.Country
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.countryRoute(countryService: CountryService) {
    route("/country") {
        get {
            val countries = countryService.getAllCountries()
            call.respond(HttpStatusCode.OK, countries)
        }
        post {
            val country = call.receive<Country>()
            try {
                val result = countryService.addCountry(country)
                result?.let { call.respond(HttpStatusCode.Created, it) } ?: call.respond(
                    HttpStatusCode.NotImplemented,
                    "Invalid country data",
                )
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, e.message ?: "SQL Exception!!")
            }
        }
        get("/{id}") {
            val id = call.parameters["id"]
            id?.let {
                countryService.getCountry(it)?.let {
                    call.respond(HttpStatusCode.OK, it)
                } ?: call.respond(HttpStatusCode.NotFound, "Country not found")
            } ?: call.respond(HttpStatusCode.BadRequest, "Invalid country id")
        }
    }
}
