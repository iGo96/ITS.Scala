/**
  * Created by Igor Vukajlovic on 08/02/2017.
  */

case class CC_Point(x: Int, y: Int) {
  def distance(p: Point): Double = {

    def square(v: Int): Double = {
      Math.pow(v, 2)
    }

    Math.sqrt(square(x - p.x) + square(y - p.y))
  }

  def +(p: Point): CC_Point = CC_Point(x + p.x, y + p.y)

  override def toString: String = s"($x, $y)"
}

object CC_Point {
  def origin(): CC_Point = new CC_Point(0, 0) // l'origine è un punto con coordinate 0 e 0
}

object CaseClass_Point {
  def main(args: Array[String]): Unit = {
    val p1 = CC_Point(1, 2)

  }
}

