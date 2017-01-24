/**
  * Created by Igor Vukajlovic on 23/01/2017.
  */
object Exercises {
  // Create and function subtraction that accept two integer parameters and return
  // a value of type integer. Print the result of 7-5 and 2-7.
  def sub(a: Int, b: Int): Int = a - b

  // Create a function division that accept two integer parameters and return a
  // value of type double. Print the result of 6/2 and 2/3
  def div(a: Int, b: Int): Double ={
    val res
    if(b >= 0)
      res = a / b
    else
      res = null // not sure if it'll work (res isn't an obj)
    res
  }

  //Given a word write a function that print:
  // “short” if the length of the word is less than 4 character
  // “medium” if the length of the word is between 4 and 10 characters
  // “long” if the length of the word is more than 10 character
  def lenStr(str: String): String ={
    val output: String

    if (str.length() < 4)
      output = "short"
    else if ((str.length() >= 4) && (str.length() <= 10))
      output = "medium"
    else
      output = "long"
    output
  }

  // Write a recursive function (sumall) that given a integer value n, return the sum
  // of the first n values. (e.g. sumall(5) = 5+4+3+2+1 = 15)
  //  print the result of summall(10) and sumall(100000)
  def sumAll(value: Int): Int = {
    val res: Int
    if (value > 0)
      res += value // res shouldn't change it's state.. It isn't correct
      sumAll(value - 1)
    res
  }

  // Transform the function in a tail-recursive functions
  //  print the result of sumall(10) and sumall(100000)
  def sumAllT(value: Int): Int = {

  }

  // Write a recursive function that calculate the multiplication of two numbers
  def mul(a: Int, b: Int): Int = { // I suppose numbers are integers

  }


  // Given two integers a, b write a recursive function that sum the values from a to b (both inclusive)
  def sum(a: Int, b: Int): Int ={
    if (a <= b) {
      sum(a + 1, b)
    }
    1
  }

  // Given two integers a, b write a recursive function that sum the square of the values from a to b (both inclusive)
  def sumSq(a: Int, b: Int): Int ={

  }

  // Given two integers a, b write a recursive function that sum the cube of the values from a to b (both inclusive)
  def sumCube(a: Int, b: Int): Int ={

  }

  // Given two integers a, b and a function f, write a recursive function that sum the result of applying f to the values
  // from a to b (both inclusive)
  //  print the result with function f as identity, square and cube functions
  //  print the result with function f as identity, square and cube anonymous functions


  // Create a function that returns a function that calculate the square of an integer
  //  apply the square function to calculate the square of 4 and 8



  // ----------------------------------------
  def main(args: Array[String]): Unit = {
    // sub
    println (sub(7, 5))
    println (sub(2, 7))
  }
}
