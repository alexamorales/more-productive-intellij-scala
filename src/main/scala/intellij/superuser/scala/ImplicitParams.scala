package intellij.superuser.scala

object ImplicitParams {

  def greet(name: String)(implicit age: Int): Unit = println(s"Hi $name, $age")

  implicit val defaultAge = 18

  // View / Parameter Info (Ctrl + P) now shows all parameter lists, including implicit ones
  greet("Name")

  greet("Name")(20)

  // View / Show Implicit Hints reveals actual arguments to implicit parameters
  // You may also invoke Parameter Info to see both the parameters and the arguments at once
  greet("Name")

  // Ctrl + Alt + Shift + "+" enables the mode
  // Ctrl + Alt + Shift + "-" disables the mode
  // Find Action (Ctrl + A) can show / update "Show Implicit Hints" state
  // You may right-click on the hint and see / update "Show Implicit Hints" state

  // You can see a tooltip with details by pressing Ctrl / Cmd and holding mouse pointer over a hint
  greet("Your name")

  def acceptNotDefinedImplicit(implicit b: Boolean): Unit = ()
  acceptNotDefinedImplicit

  //it also show ambiguous implicit arguments
  //you need to press on ... to expand it
  // you can revert state by pressing Esc
  {
    implicit val eventuallyFalse: Boolean = true
    implicit val eventuallyTrue: Boolean = true

    acceptNotDefinedImplicit
  }

}
