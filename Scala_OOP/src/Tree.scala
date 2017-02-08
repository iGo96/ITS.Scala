import com.sun.org.apache.xpath.internal.operations.And

/**
  * Created by Igor Vukajlovic on 08/02/2017.
  */
sealed trait Tree[+A] {
  def count: Int = this match {
    case NilT => 0
    case ConsT(_, l, r) => 1 + l.count + r.count
  }

  def map[B](f: A => B): Tree[B] = this match {
    case NilT => NilT
    case ConsT(v, l, r) => ConsT(f(v), l.map(f), r.map(f))
  }
}

object Tree {
  def maximum(t: Tree[Int]): Int=  {

    def maximumB(t: Tree[Int], max: Int): Int = t match {
      case NilT => max
      case ConsT(v, l, r) => {
        val newmax =  v maximum max
        maximumB(l, newmax) maximum maximumB(r, newmax)
      }
    }

    maximumB(t, Int.MinValue)
  }
}

case object NilT extends Tree[Nothing]

case class ConsT[+A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

// extends App -> fa in modo che non si debba scrivere il main, ma tutto ciò che è
// dentro l'object viene visto come parte del main
object MyTree extends App {
  val t = ConsT(5, ConsT(2, NilT, NilT), NilT)

  println(t.count)
}