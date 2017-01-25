/**
  * Created by PC on 25/01/2017.
  */
object HighOrderFunctions {

  def MarginA(x: Int) = x / 2
  def MarginB(x: Int) = x / 5

  def productCost(netcost: Int, margin: Int => Int) = netcost + margin(netcost)

  def saySomething2(prefix: String) = (s: String) => prefix + " " + s

  def main(args: Array[String]): Unit = {
    val netcost = 100
    val grosscost = productCost(netcost, MarginA)
    val grosscost2 = productCost(netcost, x => x / 4)
    println(s"grosscost=${grosscost}, grosscost2=${grosscost2}")

    val sayHello = saySomething("Hello")
    val msg = sayHello("World")

    println (msg)
  }

  def saySomething(prefix: String): String => String = {
    def pre(s: String): String = prefix + " " + s

    pre

    // Nel caso in cui non fosse stato specificato il tipo di ritorno
    // si sarebbe dovuto tornare "pre _"
  }

  /* def saySomethingN(prefix: String) = {
    def pre(s: String): String = prefix + " " + s

    pre _

    // Nel caso in cui non venga specificato il tipo di ritorno
    // si deve tornare "pre _"
  } */

}
