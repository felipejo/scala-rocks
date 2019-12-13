package lectures.part3FunctionalProgramming

object WhatsAFunction extends App {

  // use functions as first class elements

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  //can be called as a function
  println(doubler(2))

  //function types = Function1[A,B]
  var stringToInt = new Function1[String, Int] {
    override def apply(string: String) = string.toInt
  }
  //Syntax Sugar for Function2
  //var adder : ((Int,Int) => Int) = new Function2[Int, Int, Int]{
  //Function2 has the 3rd parameter as the resultType of this function
  var adder : Function2[Int, Int, Int] = new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int): Int = a + b
  }

  //Functiontypes Function2[A,B,R] === (A,B) => R

  //ALL SCALA FUNCTIONS ARE OBJECTS or classes deriving from Function1, Function2, etc.


  val superAdder = new Function[Int, Function[Int, Int]]{
    override def apply (x: Int): Function1[Int,Int] = new Function[Int, Int] {
      override def apply(y:Int): Int = x + y
    }
  }

  val adder3 = superAdder(3);
  println(adder3(4))
  //same
  println(superAdder(3)(4)) //Curried Function could be called with multiple parameters list to get the final result.


}

trait MyFunction[A,B]{
  def apply(element: A): B
}