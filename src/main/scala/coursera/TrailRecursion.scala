package coursera

import scala.annotation.tailrec

object TrailRecursion extends App {

  /*
  In recursion, if intermediate results need to be stored for computing final result
  then such a recursion would need multiple stack frames one for each level.
  But if last call of recursion function is just a call to same function no other computing
  then same stack frame could be reused leading to optimization possible.
  Tail recursion is functional representation of loop.
  Scala @tailrec annotation when put on a recursive function check if function is trail recursive
  if not then compile time error is given.
   */
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }

  println(sum(x => x * x * x, 1, 5))

}
