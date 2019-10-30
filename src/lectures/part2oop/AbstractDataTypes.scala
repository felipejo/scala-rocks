package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract
  abstract class Animal{
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "K9"

    override def eat: Unit = {
      println("Sound of a dog eating")
    }
  }


  // Traits

  trait Carnivore{
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    def eat: Unit = println("test")
    def eat(animal: Animal): Unit = println(s"croc is eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstract classes
  //1 - Traits does not have constructor parameters
  //2 - You can only extends 1 class but multiple traits bay me inherited by the same class
  //3 - traits are behaviors, but abstract classes are types of things.
}
