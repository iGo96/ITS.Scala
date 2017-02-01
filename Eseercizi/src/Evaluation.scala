/**
  * Created by Igor Vukajlovic on 01/02/2017.
  */
object Evaluation {
  def fa(): Int = {
    println("fa")
    5
  }

  def fb(): Int = {
    println("fb")
    10
  }

  def ifelsebyvalue(b: Boolean, t: Int, e: Int): Int = if (b) t else e

  def ifelsebyname(b: Boolean, t: => Int, e: => Int): Int = if (b) t else e

  // Define a loop function as a function that calls itself and define a function first
  // thar return the first of its own two results
  //  apply the call-by-value and call-by-name strategies
  def loop(): Int = loop()
  def firstByValue(a: Int, b: Int): Int = a
  def first(a: => Int, b: => Int): Int = a

  def main(args: Array[String]): Unit = {
    // viene istanziata solo nel momento in cui viene utilizzata la prima volta
    lazy val byvalue = ifelsebyname(true , fa(), fb())
    println(s"byvalue= $byvalue") //QUI viene istanziata 'byvalue'
    val byname = ifelsebyname(true, fa(), fb())
    println(s"byname= $byname")

    val x = first(5, loop())
    println (x)
    val y = firstByValue(5, loop()) // va avanti all'infinito (e oltre)
    println (y)
  }
}
