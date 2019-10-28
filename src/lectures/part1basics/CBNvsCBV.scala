package lectures.part1basics

/**
  * Call By Name vs Call By Value
  */
object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime()); // here the parameter is passed as a parameter, and is executed before it enters in the function;
  calledByName(System.nanoTime()); //Here the parameter is passed as an expression literally, and it is executed every time within;
}
