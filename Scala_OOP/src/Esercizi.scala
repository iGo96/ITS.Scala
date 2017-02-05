/**
  * Created by Igor Vukajlovic on 01/02/2017.
  */

// Create a class Point parametrised with the constructor integer arguments x and y
// Create a companion object that create a new instance of class Point
// Define in the companion object a method origin that return a point representing the
// coordinate 0,0
// In class Point create:
//  method distance that calculate the distance among two points
//  method + that return the sum of 2 points
// Create the point p1 = Point(2, 3) and the point p2 = Point(0,0)
//  Print distance and point resulting from the sum between p1 and p2
//  override method toString
class Point(val x: Int, val y: Int) {
  def distance(p: Point): Double = {

	  def square(v: Int): Double = {
      Math.pow(v, 2)
    }

    Math.sqrt(square(x - p.x) + square(y - p.y))
  }

  def +(p: Point): Point = {
    new Point(x + p.x, y + p.y)
  }

  override def toString: String = {
    s"($x, $y)"
  }
}

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
  def origin(): Point = new Point(0, 0) // l'origine è un punto con coordinate 0 e 0
}
	
object MyObj {
  def main(args: Array[String]): Unit = {
    val origin = Point(0, 0)
    val p1 = Point(2, 3)
    val p2 = Point(1, 0)
    println(s"${origin.toString} is ${origin.distance(p1)} from ${p1.toString}")

    val newPoint = p1 + p2
    println(s"${p1.toString} + ${p2.toString} = ${newPoint.toString}")
  }
}