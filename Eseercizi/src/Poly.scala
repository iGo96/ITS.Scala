import scala.annotation.tailrec

/**
  * Created by Igor Vukajlovic on 01/02/2017.
  */
object Poly {
  def length(l: List[Int]): Int = {
    @tailrec
    def lengthT(l: List[Int], acc: Int): Int = {
      if (l == Nil) acc
      else lengthT(l, acc + 1)
    }

    lengthT(l, 0)
  }

  // Write a function that returns if an integer occurs in a List of integers or -1 if it's not found
  // Rewrite the previous function as a polymorphic functions
  //  Test with a List of String and List of integers
  // Given the following signature, write the only implementation that compile and follows logically
  // from the type signature
  // def par(A,B,C)(a:A, f(A,B) => C): B => C
  def hasVal(l: List[Int], x: Int): Boolean = {
    def hasValT(l: List[Int], x: Int, acc: Int): Boolean = l match {
      case Nil => false
      case h :: _ if h == x => true
      case _ :: t => hasValT(t, x, acc + 1)
    }
    hasValT(l, x, 0)
  }

  def hasValP[A](l: List[A], x: A): Boolean = {
    def hasValTP(l: List[A], x: A, acc: Int): Boolean = l match {
      case Nil => false
      case h :: _ if h == x => true
      case _ :: t => hasValTP(t, x, acc + 1)
    }
    hasValTP(l, x, 0)
  }

  def sum(a: Int, b: Int): Int = a + b

  def par[A, B, C](a: A, f: (A, B) => C): B => C = (b: B) => f(a, b)

  def main(args: Array[String]): Unit = {
    val l = List(1, 2, 3, 4)
    //println(length(l))

    println(s"1 is in $l : ${hasVal(l, 1)}") // TRUE
    println(s"5 is in $l : ${hasVal(l, 5)}") // FALSE

    val strL = List("a", "b", "c")
    println(s"a is in $strL? : ${hasValP(strL, "a")}") // TRUE
    println(s"d is in $strL? : ${hasValP(strL, "d")}") // FALSE
    println(s"1 is in $strL? : ${hasValP(strL, 1)}") // FALSE

    val strSI = List("1", "2", "3")
    println(s"1 is in $strSI? : ${hasValP(strSI, 1)}") // FALSE
    println(s"1 is in $strSI? : ${hasValP(strSI, "1")}") // TRUE

    val strI = List(1, 2, 3)
    println(s"1 is in $strI? : ${hasValP(strI, 1)}") // TRUE

    val s = sum(2, 3)
    println(s"sum(2,3) : $s")

    val g = par(2, sum)
    val s2 = g(3)
    println(s"sum(2,g(3)) : $s2")

    // par(2, sum)
    // (b:B) => sum(2, b) <- è una funzione che accetta 1 param
    // def k(b: B): B => sum(2, b)

    println(s2)
  }
}
