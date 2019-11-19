package lectures.part2oop

/**
  * Case classes arae a quick lightweight way to create data structures with little boilerplate
  */
object CaseClasses extends App  {

  case class Person(name: String, age: Int = 10)

  // 1- class parameters are fields
  val jim = new Person("Jim")
  println(jim.name)

  //2- Sensible toString
  //println(instance) == println(instance.toString)
  println(jim.toString)

  //3 - equals and hashcode are implemented out of the box
  val jim2 = new Person("Jim")
  println(jim == jim2)

  //4 - case classes have copy method
  val jim3 = jim.copy(age = 12)
  println(jim3)

  //5 - Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  //6 - Case classes are serializable
  //Akka framework for example

  //7 - Case classes have extractor patterns - can be used in PATTERN MATCHING

  //8
  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  }
}
