package hack

import spark.Request
import spark.Response
import spark.Route

class AddPublisherRoute : Route {
    override fun handle(request: Request, response: Response) {
        publishers.add(Publisher(
            publishers.size +1,
            request.queryParams("name"),
            request.queryParams("address"),
            request.queryParams("mobile"),
            request.queryParams("times"),
            request.queryParams("offer")
        ))

        response.redirect("/");
    }
}
