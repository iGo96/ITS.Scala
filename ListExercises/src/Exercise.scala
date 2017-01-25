import scala.annotation.tailrec
import scala.math.sqrt
import scala.math.pow

/**
  * Created by PC on 25/01/2017.
  */
object Exercise {
  // Create a recursive function that return the length of a List
  def listLen(list: List[Int]): Int = {
    @tailrec
    def listLenB(list: List[Int], acc: Int): Int = {
      if (list == List()) acc
      else listLenB(list.tail, acc + 1)
    }

    listLenB(list, 0)
  }

  def listLenNT(list: List[Int]): Int = {
    if (list == List()) 0
    else 1 + listLenNT(list.tail)
  }

  // Given a integer List A calculate the square root of the sum of the square
  // of the only even elements
  //  print the result for List(1,-4,5,9)
  def sqRootEven(a: List[Int]): Double = sqrt(a.filter(x => x % 2 == 0).map(x => x * x).sum) //sum = reduce((x, y) => x + y)
  //def sqRootEven(a: List[Int]): Double = sqrt(a.filter(_ % 2 == 0).map(pow(_, 2)).reduce(_ + _))

  def sumElements(list: List[Int]): Int = {
    @tailrec
    def sumElementsB(list: List[Int], acc: Int): Int = {
      if (list == Nil) acc // Nil = List() (lista vuota)
      else sumElementsB(list.tail, acc + list.head)
    }

    sumElementsB(list, 0)
  }

  def main(args: Array[String]): Unit = {
    println("listLen T: " + listLen(List(1, 2, 3, 4, 5, 6, 7)))
    println("listLen: " + listLenNT(List(1, 2, 3, 4, 5)))
    println("sumElements: " + sumElements(List(1, 2, 3)))
    println("sqRootEven: " + sqRootEven(List(1, -4, 5, 9)))

    val h = List(1,2,3,4).head
    println(s"list = ${List(1,2,3,4)} h = $h")

    val h2Option = Nil.headOption
    println(s"list = ${Nil} h = $h2Option")

    val h2 = Nil.head
    println(s"list = ${Nil} h = $h2")

  }
}
