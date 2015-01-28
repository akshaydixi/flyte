package flyte

import java.net.URL

import de.l3s.boilerpipe._
import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._


class FlyteActor extends Actor with Flyte {
  def actorRefFactory = context
  def receive = runRoute(myRoute)
}

trait Flyte extends HttpService {
  val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>Hello World</h1>
              </body>
            </html>
          }
        }
      } ~
      put {
        formField('url) { url =>
          complete {
            extractors.ArticleExtractor.INSTANCE.getText(new URL(url))
          }
        }
      }
    }
}
