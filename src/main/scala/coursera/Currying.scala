package coursera

object Currying extends App {

  def product(f: Int => Int, a: Int, b: Int): Int =
    if(a > b) 1
    else f(a) * product(f, a + 1, b)

  println(product(x => x, 1, 5))

  def factorial(x: Int): Int = productF(x => x)(1, x)
  val factProduct = product(factorial, 1, 5)
  println(factProduct)

  def productF(f: Int => Int): (Int, Int) => Int = {
    def func(a: Int, b: Int): Int = {
      if (a > b) 1
      else f(a) * productF(f)(a + 1, b)
    }
    func
  }

  val functionOfFunctionRes: Int = productF(factorial)(1, 5)
  println(functionOfFunctionRes)

  def curry(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * curry(f)(a + 1, b)
  }

  val curriedRes: Int = curry(factorial)(1, 5)
  println(curriedRes)

  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else a + sumF(a + 1, b)


  def prodF(a: Int, b: Int): Int =
    if (a > b) 1
    else a + prodF(a + 1, b)

  def mapReduce(f: Int => Int,
                combine: (Int, Int) => Int,
                zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  val reduced: Int = mapReduce(factorial, (a, b) => a * b, 1)(1, 5)
  println(reduced)

  def sumF(f: Int => Int, a: Int, b: Int): Int = mapReduce(f, (a, b) => a + b, 0)(a, b)
  val sum: Int = sumF(1, 5)
  println(sum)
}
