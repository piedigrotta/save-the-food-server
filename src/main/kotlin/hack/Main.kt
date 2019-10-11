package hack

import org.eclipse.jetty.http.HttpStatus
import spark.Request
import spark.Response
import spark.Spark

fun main(){
    Spark.port(8080)

    Spark.get("/alive", aliveRoute())
}

private fun aliveRoute(): (Request, Response) -> String {
    return { _, res ->
        res.type("application/json")
        res.status(HttpStatus.OK_200)
        """{}"""
    }
}