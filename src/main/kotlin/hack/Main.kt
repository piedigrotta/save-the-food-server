package hack

import org.eclipse.jetty.http.HttpStatus
import spark.Request
import spark.Response
import spark.Spark.*

var offers = mutableListOf<Publisher>()
var publishers = mutableListOf(Publisher(1, "Panetteria Fracassi", "Via Moruzzi 1, Pavia", "9:00-18:00", "Pane, pizze e focacce al 50%"))

fun main() {
    staticFiles.location("/public");
    port(8080)
    get("/alive", aliveRoute())
    get("/list", ListRoute())
    get("/save", SaveRoute())
}

private fun aliveRoute(): (Request, Response) -> String {
    return { _, res ->
        res.type("application/json")
        res.status(HttpStatus.OK_200)
        "Hello"
    }
}