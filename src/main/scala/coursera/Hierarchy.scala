package coursera

object Hierarchy extends App {
  val tree1 = new NonEmptyIntSet(8, EmptyIntSet, EmptyIntSet)
  val newTree: IntSet = tree1.add(5).add(10)
  println(newTree)
  println(newTree.includes(5))
  println(newTree.includes(15))

  val thatTree = new NonEmptyIntSet(20, EmptyIntSet, EmptyIntSet)
  val newThatTree = thatTree.add(14).add(16)
  println(newThatTree)

  println(newTree.union(newThatTree))

}

abstract class IntSet {
  def includes(value: Int): Boolean
  def add(value: Int): IntSet
  def union(that: IntSet): IntSet
}

object EmptyIntSet extends IntSet {
  override def includes(value: Int): Boolean = false
  override def add(value: Int): IntSet = new NonEmptyIntSet(value, EmptyIntSet, EmptyIntSet)
  override def union(that: IntSet): IntSet = that
  override def toString: String = "."
}

class NonEmptyIntSet(element: Int, left: IntSet, right: IntSet) extends IntSet {
  override def includes(value: Int): Boolean =
    if (value < element) left includes value
    else if (value > element) right includes value
    else true

  override def add(value: Int): IntSet =
    if (value < element) new NonEmptyIntSet(element, left add value, right)
    else if (value > element) new NonEmptyIntSet(element, left, right add value)
    else this

  override def union(that: IntSet): IntSet =
    ((left union right) union that).add(element)

  override def toString: String = "{" + left + element + right + "}"
}