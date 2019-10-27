package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App
{
  def factorial(n: Int): Int = {
    if(n <= 0) 1
    else
    {
      //println("Computing the factorial of " + n + ". next is " + (n - 1))
      val result = n * factorial(n - 1)
      //println("Computed factorial of " + n)
      result
    }
  }
  println(factorial(5))
  //println(factorial(5000)) // StackOverFlow

  def anotherFactorial(n: Int): Int = {
    @tailrec //annotation that says to the compiler this function should be tail recursive
    def factorialHelper(x: Int, accumulator: Int): Int = {
      if(x <= 1) accumulator
      else factorialHelper(x -1, (x * accumulator)) // TAIL RECURSION - Use recursive call as the last expression
    }

    factorialHelper(n, 1)
  }

  println(anotherFactorial(5))

  //WHEN you need to use LOOPS, use TAIL RECURSION instead!!!!

  //Exercises
  @tailrec
  def aRepeatedFunction(aString: String, rep: Int, accumulator: String): String = {
    if (rep <= 0) accumulator
    else aRepeatedFunction(aString, rep - 1, (aString + accumulator + "_"))
  }

  println(aRepeatedFunction("hello", 3, ""))

  def isPrime(n: Int): Boolean ={
    @tailrec
    def isPrimeHelper(x: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if (x <=1) true
      else isPrimeHelper(x - 1, (n % x != 0 && isStillPrime))

    isPrimeHelper(n / 2, true)
  }
  println(isPrime(2003))

  def fibonacci(n: Int): Int =
  {
    def fibonacciHelper(i: Int, last: Int, nextLast: Int): Int =
    {
      if (i >= n) last
      else fibonacciHelper(i+1, last + nextLast, last)
    }
    if(n <= 2) 1
    else fibonacciHelper(2, 1, 1)
  }

  println(fibonacci(8))
}
