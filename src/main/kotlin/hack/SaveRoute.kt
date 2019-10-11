package hack

import spark.Request
import spark.Response
import spark.Route

class SaveRoute : Route {
    override fun handle(request: Request, response: Response): String {
        val publicherId = request.queryParams("publisherId").toInt()
        if(!offers.contains(publicherId)) {
            offers.add(publicherId)
        }
        return "ok\n"
    }
}