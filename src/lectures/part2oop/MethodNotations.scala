package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0){
    def likes(movie: String): Boolean =  movie == favoriteMovie
    def hangoutWith(person: Person) = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, wtf?!"
    def isAlive = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    //EXERCISES
    def apply(times: Int): String = s"$name watched $favoriteMovie time(s)"

    def +(nickname: String): Person = new Person(s"$name ${nickname}", favoriteMovie, age);
    def unary_+ : Person = {
      println(s"$name is getting older...")
      new Person(name, favoriteMovie, age + 1)
    }
    def learns(what: String) : Unit = println(s"$name learns $what")
    def learnsScala(): Unit = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix notation or operator notation (Only works with methods with one parameter;

  //"operators in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangoutWith tom) //in this case "hangoutWith is acting as an operator

  println(1 + 2); println(1.+(2)) //ALL OPERATORS ARE METHODS

  //prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with a few operators: - + ~ !
  println(!mary)
  println(mary.unary_!)

  //postfix notation - Only available in methods without parameters
  println(mary.isAlive)
  println(mary isAlive) //syntax sugar

  //apply
  println(mary.apply())
  println(mary()) //equivalent

  println("---------------------")

  //EXERCISES
  val john = new Person("John", "Godfather", 30)
  println((john + "Doe")()) // or println((john + "Doe").apply())
  println((+john).age)
  john learns "Java"
  john learnsScala;
  println(john(2))

}
