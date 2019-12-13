package lectures.part3FunctionalProgramming

object AnonymousFunctions extends App {

  //OOP way to create a function
  val doublerOOP = new Function1[Int, Int]{
    override def apply(v1: Int): Int =  v1 * 2
  }

  //Anonymous Function or LAMBDA
  //var doubler: Int => Int = x => x * 2
  var doubler = (x: Int) => x * 2

  //multiple params in a lambda
  //var adder: (Int, Int) => Int = (a:Int, b: Int) => a + b
  val adder = (a: Int, b: Int) => a + b

  //no params

}
