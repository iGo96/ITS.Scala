/**
  * Created by Igor Vukajlovic on 01/02/2017.
  */
object Currying {

  //Create a currying function that accept a binary operator and the two params.
  // Call example: binaryOperation(add)(2,4) with add a function that return the
  //sum of two arguments.
  // What is the type of val x in the following code:
  //  val x = binaryOperation(add) _
  def sum(x: Int, y: Int): Int = x + y
  def mul(x: Int, y: Int): Int = x * y
  def sub(x: Int, y: Int): Int = x - y
  def div(x: Int, y: Int): Double = {
    if (y != 0) x / y
    else throw new Exception("Cannot divide by 0")
  }

  def binaryOperation(f: (Int, Int) => Double)(x: Int, y: Int): Double = f(x, y)

  def square(a: Int):Long = a * a
  def sumOfSquares(a: Int, b: Int): Long = square(a) + square(b)

  def main(args: Array[String]): Unit = {
    val a = 6
    val b = 4
    println (s"sum($a, $b): " + binaryOperation(sum)(a, b))
    println (s"mul($a, $b): " + binaryOperation(mul)(a, b))
    println (s"sub($a, $b): " + binaryOperation(sub)(a, b))
    try {
      println(s"div($a, $b): " + binaryOperation(div)(a, b))
      println(s"div($a, $b): " + binaryOperation(div)(a, 0))
    } catch{
      case e: Exception => println (e.getMessage)
    }
    val x = 2
    val y = 4
    val fnSum = binaryOperation(sum) _ // tipo dato : funzione che accetta 2 params
    println (s"fnAdd($x, $y): " + fnSum(x,y))
  }
}
