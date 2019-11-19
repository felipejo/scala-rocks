package lectures.part2oop

object Generics extends App {

  class MyList[+A]{
    //use the type A in class definition
    def add[B>:A](element: B): MyList[B]= ???

  }
  val listOfIntegers = new MyList[Int]

  //generic methods
  object MyList{
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInts = MyList.empty[Int]

  //VARIANCE PROBLEM

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new dog) ??? answer: you can do this using low bounded type:  def add[B>:A](element: B): MyList[B]

  class InvariantList[A]
  //You cannot put another type it will give you an error
  //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //CONTRAVARIANCE
  class Contravariantlist[-A]
  val contravariantlist: Contravariantlist[Cat] = new Contravariantlist[Animal]
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //BOUNDED TYPES

  //Upper Bounded type
  // <: means subtype of. The bellow example can be read like "Accepts types that are subtypes of Animal"
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  //Low Bounded type
  // <: means supertype of. The bellow example can be read like "Accepts types that are supertypes of Cat"
  // class Cage[A >: Cat]

}
