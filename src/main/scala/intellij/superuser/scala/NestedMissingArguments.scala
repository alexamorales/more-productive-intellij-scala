package intellij.superuser.scala

class NestedMissingArguments {

  {
    class A; class B; class C; class D

    implicit def aFromB(implicit b: B): A = new A
    implicit def bFromC(implicit c: C): B = new B

//    implicit val someC: C = new C
//    implicit val someD: D = new D
//    implicit val anotherC: C = new C

    def materializeB(implicit a: A, d: D) = new B

    materializeB

  }

}
