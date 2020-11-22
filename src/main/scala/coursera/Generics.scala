package coursera

object Generics extends App {

  def nth[T](n: Int, list: List[T]): T =
    if (list.isEmpty) throw new IllegalArgumentException("Not present nth element " + n)
    else if (n == 0) list.head
    else nth(n - 1, list.tail)

  val myList = new ContList[Int](1, new ContList[Int](2, new ContList[Int](3, new ContList[Int](4, new EmptyList[Int]))))
  println(nth(2, myList))
  nth(6, myList)
}

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class EmptyList[T] extends List[T] {
  override def isEmpty: Boolean = true
  override def head: T = throw new NoSuchElementException("Empty.head")
  override def tail: List[T] = new EmptyList[T]
}

//val in below params creates def of that name
//like fields
class ContList[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}
