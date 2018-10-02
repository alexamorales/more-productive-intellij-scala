package intellij.superuser.scala
import scala.annotation.tailrec

object Recursion {

  def fibReg(n: Int): Int = n match {
    case 0 | 1 => n
    case _     => fibReg(n - 1) + (n - 2)
  }

  def fibTail(n: Int): BigInt = {

    @tailrec
    def fibHelper(x: Int = 0, prev: BigInt = 0, next: BigInt = 1): BigInt = n match {
      case 0 => prev
      case 1 => next
      case _ => fibHelper(x - 1, next, prev + next)
    }

    fibHelper(n)
  }

}
