/**
  * Created by Igor Vukajlovic on 08/02/2017.
  */
// +A -> permette di applicare la covarianza
sealed trait MyList[+A] {

  def length: Int = this match {
    case Nil => 0
    case Cons(_,t) => 1 + t.length
  }

  def map[B](f: A => B): MyList[B] = this match {
    case Nil => Nil
    case Cons(h,t) => Cons(f(h), t.map(f))
  }
}

case object Nil extends MyList[Nothing]
case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A]

object MyList {
  // A* -> numero indefinito di parametri
  def apply[A](as: A*): MyList[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

}

object TestMyList {
  def main(args: Array[String]): Unit = {
    val c1 = Cons(1, Cons(2, Nil))
    val c2 = MyList(1,2,3)

    println(c1)
    println(c1.length)
    println(c1.map(x => x % 2 == 0)) // only numeri pari

    println(c2)
    println(c2.length)
    println(c2.map(x => x % 2 == 0)) // only numeri pari

  }
}