package exercises

import java.util.NoSuchElementException

abstract class MyList[+A]{

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B>: A](element: B): MyList[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B] (transformer: MyTransformer[A,B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

}

object Empty extends MyList[Nothing]{

  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B>:Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

  def map[B] (transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]])= Empty
  def filter(predicate: MyPredicate[Nothing])= Empty

  def ++[B>: Nothing](list: MyList[B]): MyList[B] = list

}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{

  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B>:A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B] (transformer: MyTransformer[A,B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  def ++[B>: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

object ListTest extends App{
  val list: MyList[Int] = new Cons(1, new Cons(2,new Cons(3, Empty)))
  val anotherList: MyList[Int] = new Cons(4, new Cons(5,Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(list.tail.head)
  println(list.add(4).head)
  println(list isEmpty)
  println(list.toString)

  println(listOfStrings toString)

  println(list.map(new MyTransformer[Int,Int] {
    override def transform(element: Int): Int = element * 2
  }).toString)

  println(list.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }).toString)

  println((list ++ anotherList).toString)
  println(list.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = new Cons(element, new Cons[Int](element + 1, Empty))
  }).toString)
}