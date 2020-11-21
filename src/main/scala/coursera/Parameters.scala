package coursera

object Parameters extends App {

  def printTime(time: Long) = {
    println(time)
    println(time)
    println("***Same value, once evaluation****")
  }

  def printTimeByName(time: => Long) = {
    println(time)
    println(time)
    println("***Argument Expression Evaluated Twice, different values****")
  }

  printTime(System.nanoTime())
  printTimeByName(System.nanoTime())

}
