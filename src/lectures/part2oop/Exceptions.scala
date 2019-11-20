package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //println(x.length) // this will crash with NullPointerException

  //1. throwing and catching exceptions
  //val aWeirdValue: String = throw new NullPointerException

  //Throwable classes extends Throwable class.
  //Exception and Error are the major throwable subtypes

  //2. Cacth Exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("no int")
    else 42

  //TRY is an expression too.
  val potentialFailure = try{
    getInt(true)

  }catch {
    case e: RuntimeException=> println("runtime caught")
  }finally {
    //code will be executed NO MATTER WHAT
    //is optional
    //does not influence of this expression
    //use finally only for side-effects (eg: log into a file)
    println("finally")
  }

  //OutOfMemoryError
  // val array = Array.Dim(Int.MaxValue)

  //StackOverflowError
  //def infinite: Int = 1 + infinite
  //val noLimit = infinite

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new Exception("larger than a Int")
      else if (x < 0 && y < 0 && result > 0) throw new Exception("another exception")
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0) throw new Exception("larger than a Int")
      else if (x < 0 && y > 0 && result > 0) throw new Exception("another exception")
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if(x > 0 && y > 0 && result < 0) throw new Exception("overflow")
      else if (x > 0 && y < 0 && result > 0) throw new Exception("underflow")
      else if (x < 0 && y > 0 && result > 0) throw new Exception("underflow")
      else result
    }

    def divide(x: Int, y: Int) = {
      if(y ==0 ) throw new Exception("division by 0")
       x / y
    }

    println(PocketCalculator.divide(2,0))

  }

}
