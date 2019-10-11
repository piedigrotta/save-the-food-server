package hack

import org.eclipse.jetty.http.HttpStatus
import spark.Request
import spark.Response
import spark.Spark.*

var offers = mutableListOf(2, 3, 4, 5, 6, 7, 8, 9)
var publishers = mutableListOf(
    Publisher(1, "Panetteria Fracassi", "Via Moruzzi 1, Giussago", "9:00-18:00", "Pane, pizze e focacce al 50%"),
    Publisher(2, "Rosticceria Francia", "Via Trento 14, Giussago", "9:00-12:00 15:00-19:00", "Pollo a 2.99€"),
    Publisher(3, "Salumeria Carnevali", "Via Spinelli 12, Giussago", "9:00-12:30 16:00-19:00", "Arrosticini di agnello al 40%"),
    Publisher(4, "Ristorante Al Naviglio", "Via Spinelli 18, Giussago", "19:00-24:00", "Tiramisù in omaggio"),
    Publisher(5, "Ristorante Cavedano", "Via Trento 18, Giussago", "19:00-24:00", "Ravioli di cinghiale in omaggio con un pasto completo"),
    Publisher(6, "Pizzeria Kebab, dal turco", "Piazza Sacchi 22, Giussago", "16:00-23:00", "Olive all'ascolana 1€ 10 pezzi"),
    Publisher(7, "Pizzeria La Rustica", "Via Marconi 22, Giussago", "18:30-23:30", "Antipasto di mare 5€"),
    Publisher(8, "Frutta amica", "Via De Gasperi 12, Giussago", "09:30-18:30", "Frutta un po' avanti 1€/kg"),
    Publisher(9, "Focacceria il crostone", "Via Nenni 33, Giussago", "16:30-22:30", "Focaccia della sera 1€ al trancio")
)

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