package coursera

object AClass extends App {
  val oneByFive = new Rational(1, 5)
  val twoBySeven = new Rational(2, 7)

  val addition = oneByFive + twoBySeven
  println(addition)

  val sub = oneByFive - twoBySeven;
  println(sub)
}

class Rational(n: Int, d: Int) {
  require(d > 0, "Denominator should be positive")
  def nominator: Int = n
  def denominator: Int = d

  def +(that: Rational): Rational =
    new Rational(this.nominator * that.denominator + this.denominator * that.nominator,
      this.denominator + that.denominator)

  def unary_- : Rational =
    new Rational(-this.nominator, this.denominator)

  def -(that: Rational): Rational = this + (-that)

  override def toString: String = nominator + "/" + denominator

}
