import scala.concurrent.Future

sealed trait Event

case class Notification(title: String, body: String) extends Event
case class Warning(severity: Short, title: String, body: String) extends Event
case class Error(code: Short, reason: String) extends Event

case class UserException(reason: String) extends Exception

def processEvent(event: Event): Future[String] = {
  event match {
    case Notification(title, body)      => Future.successful(title)
    case Warning(severity, title, body) => Future.successful(title)
    case Error(code, reason)            => Future.failed(UserException(reason))
  }
}