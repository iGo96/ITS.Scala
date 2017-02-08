/**
  * Created by Igor Vukajlovic on 08/02/2017.
  */

/*ESERCIZIO COPIATO DALLA LAVAGNA*/

// Create the ASD MyOption that represents optional values. MyOption hasd the following two data constructors:
//  None that represent a value not defined
//  Some that represent a defined value
// Define the following functions as trait methods  :
//  def map[B](f: A => B): MyOption[B] = // Apply f if the MyOption is not None
//  def getOrElse[B >: A](default: => B): B // Return the option's value if the option is not None,
//   otherwise return the result of evaluating default
//  def flatMap[B](f: A => MyOption[B]): MyOption[B] // Apply f to the option if not None
//  def orElse[B >: A](ob: MyOption[B]): MyOption[B] // Don't evaluate ob unless needed
//  def filter(f: A => Boolean): MyOption[A] // Convert Some to None if the value doesn't satisfy f
trait MyOption[+A] {
  def map[B](f: A => B): MyOption[B] = this match {
    case MyNone => MyNone
    case MySome(x) => MySome(f(x))
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case MyNone => default
    case MySome(x) => x
  }

  def flatMap[B](f: A => MyOption[B]): MyOption[B] = map(f) getOrElse MyNone
  def orElse[B >: A](ob: => MyOption[B]): MyOption[B] = if (this == MyNone) ob else this
  def filter(f: A => Boolean): MyOption[A] = flatMap(x => if (f(x)) MySome(x) else MyNone)
}

case object MyNone extends MyOption[Nothing]
case class MySome[+A](x: A) extends MyOption[A]

object MyOption {
  def lift[A, B](f: A => B): Option[A] => Option[B] =
    (a: Option[A]) => a.map(f) //_ map f
  def map2[A,B,C](a: MyOption[A], b:MyOption[B])(f:(A,B) => C): MyOption[C] =
    a.flatMap(mya => b.map(myb => f(mya, myb)))
}

object TestMyOption {
  def mean(xs: Seq[Double]): MyOption[Double] = if (xs.isEmpty) MyNone
                                               else MySome(xs.sum / xs.length)

  def insouranceRateQuote(age:Int, numberOfSpeedingTickets: Int): Double = 0.0

  def parseInsouranceRateQuote(age: String, numberOfSpeedingTickets: String): MyOption[Double] = {
    val optAge: MyOption[Int] = MyTry(age.toInt)
    val optTickets: MyOption[Int] = MyTry(numberOfSpeedingTickets.toInt)

    MyOption.map2(optAge, optTickets)(insouranceRateQuote)
  }

  def MyTry[A](a: => A): MyOption[A] =
    try MySome(a)
    catch {
      case e: Exception => MyNoness
    }
}