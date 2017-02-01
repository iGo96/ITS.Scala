import scala.annotation.tailrec

/**
  * Created by Igor Vukajlovic on 25/01/2017.
  */
object Exercises {

  // Create and function subtraction that accept two integer parameters and return
  // a value of type integer. Print the result of 7-5 and 2-7.
  def sub(a: Int, b: Int): Int = a - b

  // Create a function division that accept two integer parameters and return a
  // value of type double. Print the result of 6/2 and 2/3
  def div(a: Int, b: Int): Double = {
    val res = if (b >= 0)
      a / b
    else
      throw new Exception("Divisore 0 non ammesso")
    res
  }

  //Given a word write a function that print:
  // “short” if the length of the word is less than 4 character
  // “medium” if the length of the word is between 4 and 10 characters
  // “long” if the length of the word is more than 10 character
  def lenStr(str: String): String = {
    val output = if (str.length() < 4)
      "short"
    else if ((str.length() >= 4) && (str.length() <= 10))
      "medium"
    else
      "long"
    output
  }

  def lenStrPM(str: String): String = str match {
    case `str` if str.length() < 4 => "short"
    case `str` if (str.length() >= 4) && (str.length() <= 10) => "medium"
    case _ => "long"
  }

  // Write a recursive function (sumall) that given a integer value n, return the sum
  // of the first n values. (e.g. sumall(5) = 5+4+3+2+1 = 15)
  //  print the result of summall(10) and sumall(100000)
  def sumAll(value: Int): Int = {
    if (value == 0) 0
    else value + sumAll(value - 1)
  }

  // Transform the function in a tail-recursive functions
  //  print the result of sumall(10) and sumall(100000)

  def sumAllTail(value: Int): Int = {

    // E` possibile inglobare funzioni in altre funzioni
    // in questo modo si evita che vengano richiamate le
    // "funzioni di supporto"

    @tailrec // <-- controlla che sia di coda
    def sumAllT(value: Int, acc: Int): Int = {
      if (value == 0) acc
      else sumAllT(value - 1, value + acc)
    }

    sumAllT(value, 0)
  }


  // Write a recursive function that calculate the multiplication of two numbers
  def mul(a: Int, b: Int): Int = {
    // I suppose numbers are integers
    1
  }

  // Given two integers a, b write a recursive function that sum the values from a to b (both inclusive)
  @tailrec
  def sumB(a: Int, b: Int, acc: Int): Int = {
    if (a > b) acc
    else sumB(a + 1, b, acc + a)
  }

  def sum(a: Int, b: Int): Int = {
    sumB(a, b, 0)
  }

  // Given two integers a, b write a recursive function that sum the square of the values from a to b (both inclusive)
  def sumSqB(a: Int, b: Int, acc: Int): Int = {
    def square(v: Int): Int = a * a

    if (a > b) acc
    else sumSqB(a + 1, b, acc + square(a))
  }

  def sumSq(a: Int, b: Int): Int = {
    sumSqB(a, b, 0)
  }

  // Given two integers a, b write a recursive function that sum the cube of the values from a to b (both inclusive)
  def sumCubeB(a: Int, b: Int, acc: Int): Int = {
    def cube(v: Int): Int = a * a * a

    if (a > b) acc
    else sumCubeB(a + 1, b, acc + cube(a))
  }

  def sumCube(a: Int, b: Int): Int = {
    sumCubeB(a, b, 0)
  }

  // Given two integers a, b and a function f, write a recursive function that sum the result of applying f to the values
  // from a to b (both inclusive)
  //  print the result with function f as identity, square and cube functions
  //  print the result with function f as identity, square and cube anonymous functions
  def sumCustB(a: Int, b: Int, f: Int => Int, acc: Int): Int = {
    if (a > b) acc
    else sumCustB(a + 1, b, f, acc + f(a))
  }

  def identity(x: Int) = x

  def square(x: Int) = x * x

  def cube(x: Int) = x * x * x

  def sumCust(a: Int, b: Int, f: Int => Int): Int = {
    sumCustB(a, b, f, 0)
  }

  // Create a function that returns a function that calculate the square of an integer
  //  apply the square function to calculate the square of 4 and 8
  def squareRet(v: Int) = {
    (v: Int) => v * v
  }

  // ----------------------------------------
  def main(args: Array[String]): Unit = {
    println("sub : " + sub(2, 6))
    println()
    println("lenStr : " + lenStr("123"))
    println("lenStr : " + lenStr("1234"))
    println("lenStr : " + lenStr("12345678901"))
    println()
    println("lenStrPM : " + lenStrPM("123"))
    println("lenStrPM : " + lenStrPM("123456"))
    println("lenStrPM : " + lenStrPM("12345678901"))
    println()
    println("sum : " + sum(2, 4))
    println("sumSq : " + sumSq(2, 4))
    println("sumCube : " + sumCube(2, 4))
    println()
    println("sumCust identity : " + sumCust(2, 4, identity))
    println("sumCust square : " + sumCust(2, 4, square))
    println("sumCust cube : " + sumCust(2, 4, cube))
    println()
    println("squareRet: " + squareRet(4))
    println("squareRet: " + squareRet(8))
  }
}
