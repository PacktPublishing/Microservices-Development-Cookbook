package messageservice

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8082")
    .acceptHeader("application/json")

  val scn = scenario("Create a message")
    .exec(
      http("createMessage")
        .post("/")
        .header("Content-Type", "application/json")
        .body(StringBody("""{"sender": "user:32134", "recipient": "user:12345", "body": "Hello there!", "attachment_uri": "http://foo.com/image.png"}"""))
        .check(header(HttpHeaderNames.Location).saveAs("location"))

    )
    .pause(1)
    .exec(
      http("getMessage")
        .get("${location}")
    )

  setUp(scn.inject(atOnceUsers(50)).protocols(httpConf))
}
