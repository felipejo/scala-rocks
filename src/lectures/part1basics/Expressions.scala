package lectures.part1basics

object Expressions extends App
{
  val x = 1 + 2 //EXPRESSION
  println(x)

  println(2 + 3 * 4)

  //Instruction(DO something) vs Expressions(give me the VALUE of something)

  var aCondition = true
  val aCOnditionedValue = if(aCondition) 5 else 3 //IF EXPRESSION

  println(aCOnditionedValue)

  var i = 0
  while (i <10) //NEVER USE LOOPS IN SCALA
  {
    println(i)
    i += 1
  }

  var aVariable = 3;

  //EVERYTHING in SCALA is an EXPRESSION!

  val aWeirdValue = (aVariable = 4) //Unit == void
  println(aWeirdValue)

  //side effects always returns Unit: println(), whiles, reassigning vars, etc

  //CODE BLOCKS

  //The value of a code block is the value of its last expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if(z > 2) "hello" else "goodbye"
  }

  println(aCodeBlock)
}
