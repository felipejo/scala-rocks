package exercises

import java.util.NoSuchElementException

abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B>: A](element: B): MyList[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList[Nothing]{

  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B>:Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

}

class Cons[+A](headParam: A, tailParam: MyList[A]) extends MyList[A]{

    def head: A = headParam
    def tail: MyList[A] = tailParam
    def isEmpty: Boolean = false
    def add[B>:A](element: B): MyList[B] = new Cons(element, this)

   def printElements: String =
     if(tailParam.isEmpty) "" + headParam
     else headParam + " " + tailParam.printElements

}

object ListTest extends App{
  val list = new Cons(1, new Cons(2,new Cons(3, Empty)))

  println(list.tail.head)
  println(list.add(4).head)
  println(list isEmpty)
  println(list.toString)

  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfStrings toString)
}