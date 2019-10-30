package lectures.part2oop

object Objects extends App{

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY("static")
  // you should use object


  object Person {
    //"static"/"class" - level functionality
    val N_EYES = 2

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person (val name: String){
    // instance-level functionality

  }

  //Objects and classes with the same name are called COMPANIONS

  println(Person.N_EYES)

  //Scala object is singleton instance

  val mary = Person
  val john = Person
  println(mary == john) //point to the same instance

  val person1 = new Person("person1")
  val person2 = new Person("person2")
  println(person1 == person2) // different instances

  val bobbie = Person(person1, person2)

  //scala applications = scala object with a very particular method:
  //def main(args: Array[String]): Unit



}
