package flyte

import java.net.URL

import akka.actor.Actor
import de.l3s.boilerpipe._
import org.xml.sax.InputSource
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
      post {
        formField('url) { url =>
          complete {
            val is = new InputSource()
            is.setEncoding("UTF-8")
            is.setByteStream((new URL(url)).openStream())
            extractors.ArticleExtractor.INSTANCE.getText(is)
          }
        }
      }
    }
}
