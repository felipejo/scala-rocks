package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFuntion(): Int = {
    42
  }

  println(aParameterlessFuntion())
  println(aParameterlessFuntion)

  def aRepeatedFunction(aString: String, rep: Int): String ={
    if (rep == 1) aString
    else aString + aRepeatedFunction(aString, rep-1)
  }

  println(aRepeatedFunction("hello", 3))

}
