package intellij.superuser.scala

import scala.concurrent.Future

object PatternAutocompletion {

//  Autocompletion: exhaustive pattern matching and pattern completion

  def processEvent(event: Event): Future[String] = {
    event match {
      case Notification(title, body)      => Future.successful(title)
      case Warning(severity, title, body) => Future.successful(title)
      case Error(code, reason)            => Future.failed(UserException(reason))
    }
  }

  def notifyCreature(creature: Creature) = creature match {
    case
  }


}

sealed trait Event

case class Notification(title: String, body: String) extends Event
case class Warning(severity: Short, title: String, body: String) extends Event
case class Error(code: Short, reason: String) extends Event

case class UserException(reason: String) extends Exception

class Creature
class Human extends Creature
class Animal extends Creature
