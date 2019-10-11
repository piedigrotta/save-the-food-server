package hack

import com.eclipsesource.json.Json
import org.eclipse.jetty.http.HttpStatus
import spark.Request
import spark.Response
import spark.Route
import com.eclipsesource.json.JsonObject


class ListRoute : Route {
    override fun handle(request: Request, response: Response): String {
        response.type("application/json")
        response.status(HttpStatus.OK_200)

        val array = Json.array()
        offers.reversed().map { offer ->
            publishers.single { publisher ->
                offer == publisher.id
            }
        }.forEach { array.add(it.toJson()) }
        return array.toString() + "\n"
    }
}