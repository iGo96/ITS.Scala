/**
  * Created by Igor Vukajlovic on 08/02/2017.
  */
trait Bird {}

trait Swimming {
  def swim(): Unit = println("I'm swimming")
}

trait Flying {
  def flyMessage: String
  def fly(): Unit = println(flyMessage)
}

class Pigeon extends Bird with Swimming with Flying{
  def flyMessage = "I'm a good flyer"
}
class Hawk extends Bird with Swimming with Flying{
  def flyMessage = "I'm an excellent flyer"
}
class Frigatebird extends Bird with Flying{
  def flyMessage = "I'm an excellent flyer"
}

class Penguin extends Bird with Swimming

object Traits {
  /*  def split(s: String, separator: Char): Array[String] ={
    s.foreach(c => {
      if(
    })
    Array(first, second)
  }*/

  def main(args: Array[String]): Unit = {
    val SwimmerFlyer = List(
      new Pigeon,
      new Hawk
    )

    val Flyer = List(
      new Pigeon,
      new Hawk,
      new Frigatebird
    )

    val Swimmer = List(
      new Pigeon,
      new Hawk,
      new Penguin
    )

    val birds = List(
      new Pigeon,
      new Hawk,
      new Penguin,
      new Frigatebird
    )

    SwimmerFlyer.foreach(bird =>{
      //print(split(bird.getClass, ' ') + " : ")
      bird.fly()
      print(bird.getClass + " : ")
      bird.swim()
    })

    Flyer.foreach(bird =>{
      print(bird.getClass() + " : ")
      bird.fly()
    })

    Swimmer.foreach(bird =>{
      print(bird.getClass() + " : ")
      bird.swim()
    })

    birds.foreach(bird =>{
      println(bird.getClass() + ": I'm a fuckin bird")
    })
  }
}