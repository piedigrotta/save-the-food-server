package hack

import spark.Request
import spark.Response
import spark.Route

class SaveRoute : Route {
    override fun handle(request: Request, response: Response): String {
        offers.add("cane")
        return "ok"
    }
}