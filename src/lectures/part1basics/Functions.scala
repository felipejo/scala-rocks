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

  //When needs to use loops, use RECURSION instead;

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b:Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  //Exercises

  def greetings(name: String, age: Int): Unit = println("Hi, my name is " + name + " and I am " + age + " years old.")
  println(greetings("Ana" , 26))

  def factorial(n: Int): Int = {
      if(n <= 0) 1
      else n * factorial(n - 1)
  }
  println(factorial(5)) //Should be 120

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }
  println(fibonacci(5))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if(t <=1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n / 2)
  }
  println(isPrime(2003))
}
