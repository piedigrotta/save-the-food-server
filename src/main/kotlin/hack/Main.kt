package hack

import org.eclipse.jetty.http.HttpStatus
import spark.Request
import spark.Response
import spark.Spark.get
import spark.Spark.port

var offers = mutableListOf("a", "b")

fun main() {
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

