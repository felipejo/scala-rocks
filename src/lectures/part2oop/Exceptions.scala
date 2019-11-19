package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //println(x.length) // this will crash with NullPointerException

  //throwing and catching exceptions
  val aWeirdValue: String = throw new NullPointerException

  //Throwable classes extends Throwable class.
  //Exception and Error are the major throwable subtypes
}
