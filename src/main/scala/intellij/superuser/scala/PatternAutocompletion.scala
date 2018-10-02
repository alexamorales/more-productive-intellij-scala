package intellij.superuser.scala

import scala.collection.mutable
import scala.concurrent.Future

object PatternAutocompletion {

//  Autocompletion: exhaustive pattern matching and pattern completion
  def main(args: Array[String]): Unit = {

    val b1 = Board(20, 30)
    val b2 = Board(30, 30)

    val warning = Warning(2, "Be carefull next time!", "just body")
    processEvent(warning)
  }

  case class Board(length: Int, height: Int) {
    case class Coordinate(x: Int, y: Int) {
      require(0 <= x && x < length && 0 <= y && y < height)
    }

    val occupied: mutable.Set[Coordinate] = scala.collection.mutable.Set[Coordinate]()
  }

  def processEvent(event: Event): Future[String] = {
    event match {
      case Notification(title, body)      => Future.successful(title)
      case Warning(severity, title, body) => Future.successful(title)
      case Error(code, reason)            => Future.failed(UserException(reason))
    }
  }

  def notifyCreature(creature: Creature) = creature match {
    case human: Human =>
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
