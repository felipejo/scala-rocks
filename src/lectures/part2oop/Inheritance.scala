package lectures.part2oop

object Inheritance extends App{

  //Single class Inheritance

  sealed class Animal{
    val creatureType = "wild"
    protected def eat = println("eating")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructors

  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  //class Adult(name: String, age: Int, idCard:String) extends Person(name, age)
  class Adult(name: String, age: Int, idCard:String) extends Person(name)


  //overriding

  class Dog (override val creatureType: String) extends Animal {
    //override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("dog eating")
    }
  }

  //val dog = new Dog
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)


  // type substitution (broad = polymorphism)

  val unknownAnimal: Animal = new Dog("K9")
  //unknownAnimal.eat


  //super Dog.eat

  //preventing overriding:
  // 1- use final on member(field and method)
  // 2- use final on entire class
  // 3- seal the class = extend classes in this FILE, preventing extension in other files



}
