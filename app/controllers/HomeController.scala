package controllers

import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

import javax.inject._
import scala.io.Source

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def json() = Action { implicit request: Request[AnyContent] =>
    val source: String = Source.fromFile("resources/sample.json").getLines.mkString
    val json: JsValue = Json.parse(source)
    Ok(Json.prettyPrint(json))
  }
}
