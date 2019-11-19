package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal{
    def eat: Unit
  }

  //anonymous class
  val funnyAnimal: Animal = new Animal{
    override def eat: Unit = println("eating")
  }
  /*
    equivalent with:
    class AnonymousClasses$$anon$1 extends Animal{
      override def eat: Unit = println("eating")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1


    the compiler did this behind the scenes
   */

  println(funnyAnimal.getClass)

  class Person(name: String){
    def sayHi: Unit = print(s"Hi my name is ${name}")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi my name is Jim")
  }
}
