package hack

import spark.Request
import spark.Response
import spark.Route

class SaveRoute : Route {
    override fun handle(request: Request, response: Response): String {
        val publisher = publishers.single { it.id == request.queryParams("publisherId").toInt() }
        offers.add(publisher)
        return "ok\n"
    }
}