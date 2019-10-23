package lectures.part1basics

object ValuesVariablesTypes extends App
{
  //Compiler can infer types
  //val are immutable
  //val x: Int = 42
  val x = 42

  println(x)

  //BASIC TYPES
  //val aString: String = "hello"
  val aString = "hello"
  val aBoolean: Boolean = true
  var aChar: Char = 'a'
  var anInt: Int = x
  val aShort: Short = 4123
  val aLong: Long = 212454545454L
  val aFloat: Float = 3.14f
  val aDouble: Double = 3.14

  //VARIABLES
  //Variables are mutable
  var aVariable: Int = 4

  aVariable = 5 //side effects
  aVariable += 1

}
