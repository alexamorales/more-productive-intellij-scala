package intellij.superuser.scala

class ImplicitConversions {
  // Implicit conversions are also revealed
  // You may right-click on the conversion and choose "Make explicit"
  {
    implicit def stringToInt(s: String): Int = Integer.parseInt(s)

    val i: Int = "123"
  }

  // Implicit conversions include implicit arguments with default case
  {
    implicit val default: Int = 23
    implicit def stringToIntWithMore(s: String)(implicit more: Int): Int = Integer.parseInt(s) + more

    val i: Int = "123"
  }

}
