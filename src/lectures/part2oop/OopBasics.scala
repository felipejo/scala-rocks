package lectures.part2oop

object OopBasics extends App{

  val person = new Person("John", 31)
  println(person.age)
  person.greet("Doe")
  person.greet

  val author = new Writer("Patrick", "Rothfuss", 1980)
  val novel = new Novel("The name of the wind", author, 2010)

  println("Author's fullname: " + author.fullname())
  println("Age of the author when he/she wrote the novel: "+ novel.authorAge())
  println(s"This novel was written by ${author.name}: ${novel.isWrittenBy(author)}")


  val counter = new Counter()
  counter.increment.print

}

class Person (name: String, val age: Int){
  //body

  println("A Person was Instantiated")

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors or overloaded constructors

  def this(name: String) = this(name, 0)
}

//EXERCISES

class Writer(val name: String, surname: String, val yearOfBirth: Int){
  def fullname(): String = s"${this.name} ${this.surname}"
}

class Novel (val name: String, var author: Writer, val release: Int){

  def authorAge():Int = release - author.yearOfBirth

  def isWrittenBy(author: Writer) = this.author == author

  def copy(newRelease: Int): Novel = new Novel (name, author, newRelease)
}

class Counter(value: Int = 0){

  def currentCount() = value

  def increment() = {
    println("Incrementing...")
    new Counter (value + 1)
  }
  def decrement() = {
    println("Decrementing...")

    new Counter (value - 1)
  }
  //def increment(amount: Int) = new Counter(value + amount)
  //def decrement(amount: Int) = new Counter(value - amount)
  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else increment.increment(amount - 1)
  }

  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement.decrement(amount - 1)
  }

  def print = println(value)
}