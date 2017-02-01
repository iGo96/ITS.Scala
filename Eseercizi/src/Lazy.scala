/**
  * Created by Igor Vukajlovic on 01/02/2017.
  */
object Lazy {
  // Create a List of ints and first filter all values less than 20 and then, on the resulting list,
  // all values more than 10
  //  use the scala function filter to filter the list.
  //  test the list (1, 15, 30, 5, 33) and print the resulted list and every call made to the functions
  //  lessThan20 and moreThan10
  // Now replace the function filter with the function withFilter
  // What is the difference between the two filter function: filter and withFilter?

  def lessThan20(x: Int): Boolean = {
    println(s"is $x < 20?")
    x < 20
  }

  def moreThan10(x: Int): Boolean = {
    println(s"is $x > 10?")
    x > 10
  }

  def main(args: Array[String]): Unit = {
    lazy val IntList: List[Int] = List(1, 15, 30, 5, 33)

    val IntListMax10 = IntList.filter(x => lessThan20(x)).filter(x => moreThan10(x))
    println(IntListMax10)

    println("---")

    val IntListMax10W = IntList.withFilter(x => lessThan20(x)).map(x => x).withFilter(x => moreThan10(x)).map(x => x)
    println(IntListMax10W)
  }

}
