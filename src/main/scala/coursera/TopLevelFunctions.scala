package coursera

object TopLevelFunctions extends App {

  def sum(a: Int, b: Int): Int = {
    if (a > b) 0 else a + sum(a + 1, b)
  }
  println(sum(1, 5))

  def summer(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + summer(f, a + 1, b)
  }

  def sumNumbers(a: Int, b: Int) = summer(id, 1, 5)
  def sumCubes(a: Int, b: Int) = summer(x => x*x*x, 1, 5)
  def sumFactorials(a: Int, b: Int) = summer(factorial, 1, 5)

  println(sumNumbers(1, 5))
  println(sumCubes(1, 5))
  println(sumFactorials(1, 5))

  def id(x: Int): Int = x
  def factorial(x: Int): Int = if (x == 0) 1 else x * factorial(x-1)

}
