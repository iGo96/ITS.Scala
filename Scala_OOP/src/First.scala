/**
  * Created by Igor Vukajlovic on 01/02/2017.
  */
class Multiplier(val x: Int) {
  def product(y: Int): Long = x * y
}

object Multiplier {
  def apply(x: Int) = new Multiplier(x)
}

object MyObj2{
  def main(args: Array[String]): Unit = {
    // Richiama il class
    val k = new Multiplier(5)
    println(k.x)

    // Richiama l'object
    val m = Multiplier(5)
    println(m.x)

    // Richiama l'object
    val r = Multiplier
    val n = r.apply(5) // r(5) funziona perché implicitamente viene chiamato apply
    println(n.x)
  }
}