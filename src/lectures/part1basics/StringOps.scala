package lectures.part1basics

object StringOps extends App {

  val str: String = "hello, I am coding scala!!"

  println(str.charAt(2)) // print 'l'
  println(str.substring(7,11)) // print 'I wa'
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "_"))
  println(str.toLowerCase)
  println(str.toUpperCase)
  println(str.length)
  println(str.take(2)) //prints "He"

  val aNumberInString = "45"
  val aNumber = aNumberInString.toInt

  //Scala specifics bellow
  println('a' +: aNumberInString :+ 'z')

  //Interpolators

  val age = 12
  val name = "Joe"
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"

  println(greeting)
  println(anotherGreeting)

  // F-Interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-Interpolator
  println("this is a \n new line")
  println(raw"this is a \n new line")
  val escapedLine = "this is a \n new line"
  println(raw"$escapedLine")



}
